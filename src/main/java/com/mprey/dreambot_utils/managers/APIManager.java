package com.mprey.dreambot_utils.managers;

import com.google.gson.Gson;
import com.mprey.dreambot_utils.DreambotUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIManager {

    public static <T> T sendGETRequest(String endpoint, Class<T> responseType) {
        return new Gson().fromJson(getGETString(endpoint), responseType);
    }

    public static <T> T sendGETRequest(String endpoint, Type responseType) {
        return new Gson().fromJson(getGETString(endpoint), responseType);
    }

    private static String getGETString(String endpoint) {
        try {
            URL url = new URL(getURLBase() + endpoint);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                return response.toString();
            }
        } catch (Exception e) {
            DreambotUtils.log("Error sending GET request: " + e.getMessage());
            return null;
        }
    }

    public static <T> T sendPOSTRequest(String endpoint, Object body, Class<T> responseType) {
        return new Gson().fromJson(getPOSTString(endpoint, body), responseType);
    }

    public static <T> T sendPOSTRequest(String endpoint, Object body, Type responseType) {
        return new Gson().fromJson(getPOSTString(endpoint, body), responseType);
    }

    private static String getPOSTString(String endpoint, Object body) {
        try {
            URL url = new URL(getURLBase() + endpoint);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            String jsonInputString = new Gson().toJson(body);

            con.setConnectTimeout(5000);
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");

            OutputStream os = con.getOutputStream();
            os.write(jsonInputString.getBytes("UTF-8"));
            os.close();

            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                return response.toString();
            }
        } catch (Exception e) {
            DreambotUtils.log("Error sending POST request: " + e.getMessage());
            return null;
        }
    }

    private static String getURLBase() {
        return DreambotUtils.getEnvironment().getAPI();
    }

}
