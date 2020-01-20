package com.mprey.dreambot_utils.managers;

import com.google.gson.Gson;
import com.mprey.dreambot_utils.DreambotUtils;
import com.mprey.dreambot_utils.statics.Environment;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class APIManager {

    public static <T> T sendGETRequest(String endpoint, Class<T> responseType) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(getURLBase() + endpoint);

        try {
            CloseableHttpResponse resp = client.execute(httpGet);
            String json = EntityUtils.toString(resp.getEntity());
            return new Gson().fromJson(json, responseType);
        } catch (Exception e) {
            DreambotUtils.log("Unable to send GET request to " + endpoint);
            DreambotUtils.log(e.getMessage());
            return null;
        }
    }

    public static <T> T sendPOSTRequest(String endpoint, Object body, Class<T> responseType) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(getURLBase() + endpoint);
        HttpEntity stringEntity = new StringEntity(new Gson().toJson(body), ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);

        try {
            CloseableHttpResponse resp = client.execute(httpPost);
            String json = EntityUtils.toString(resp.getEntity());
            return new Gson().fromJson(json, responseType);
        } catch (Exception e) {
            DreambotUtils.log("Unable to send POST request to " + endpoint);
            DreambotUtils.log(e.getMessage());
            return null;
        }
    }

    private static String getURLBase() {
        if (DreambotUtils.getEnvironment() == Environment.DEVELOPMENT) {
            return Environment.DEVELOPMENT.getAPI();
        } else {
            return Environment.PRODUCTION.getAPI();
        }
    }

}
