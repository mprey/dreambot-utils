package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.DreambotUtils;
import com.mprey.dreambot_utils.statics.Environment;

public class APIManager {

    public static Object sendRequest() {
        return null;
    }

    private static String getURLBase() {
        if (DreambotUtils.getEnvironment() == Environment.DEVELOPMENT) {
            return Environment.DEVELOPMENT.getAPI();
        } else {
            return Environment.PRODUCTION.getAPI();
        }
    }

}
