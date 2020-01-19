package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.Constants;
import com.mprey.dreambot_utils.DreambotUtils;

import java.util.Map;

public class APIManager {

    public static Object sendRequest() {
        return null;
    }

    private static String getURLBase() {
        Map<String, Object> params = DreambotUtils.getParams();
        String envKey = Constants.ParamKeys.ENVIRONMENT.toString();

        if (params.containsKey(envKey) && params.get(envKey).equals(Constants.Environment.DEVELOPMENT.toString())) {
            return Constants.Environment.DEVELOPMENT.getAPI();
        } else {
            return Constants.Environment.PRODUCTION.getAPI();
        }
    }

}
