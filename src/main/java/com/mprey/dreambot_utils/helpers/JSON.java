package com.mprey.dreambot_utils.helpers;

import com.google.gson.Gson;

public class JSON {

    public static <T> T parseParams(String params, Class<T> type) {
        return new Gson().fromJson(params, type);
    }

}
