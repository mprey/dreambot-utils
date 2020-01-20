package com.mprey.dreambot_utils.helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

public class JSON {

    public static Map<String, Object> parseParams(String params) {
        return new Gson().fromJson(params, new TypeToken<HashMap<String, Object>>() {}.getType());
    }

}
