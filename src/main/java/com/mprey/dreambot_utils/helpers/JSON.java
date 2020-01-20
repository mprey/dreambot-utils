package com.mprey.dreambot_utils.helpers;

import com.google.gson.Gson;
import org.dreambot.api.script.AbstractScript;

public class JSON {

    public static <T> T parseParams(String params, Class<T> type) {
        AbstractScript.log("in the thick: " + params);
        try {
            return new Gson().fromJson(params, type);
        } catch (Exception e) {
            AbstractScript.log(e.getMessage());
        }
        AbstractScript.log("BOTTOM");
        return null;
    }

}
