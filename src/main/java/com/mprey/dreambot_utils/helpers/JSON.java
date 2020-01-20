package com.mprey.dreambot_utils.helpers;

import com.google.gson.Gson;
import org.dreambot.api.script.AbstractScript;

public class JSON {

    public static <T> T parseParams(String params, Class<T> type) {
        AbstractScript.log("in the thick: " + params);
        try {
            AbstractScript.log(new Gson().toString());
            AbstractScript.log("Test");
            T result = new Gson().fromJson(params, type);
            AbstractScript.log("GOT T " + result.toString());
            return result;
        } catch (Exception e) {
            AbstractScript.log("ERRORRRR");
        }
        AbstractScript.log("BOTTOM");
        return null;
    }

}
