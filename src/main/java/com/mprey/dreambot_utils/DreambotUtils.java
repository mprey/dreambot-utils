package com.mprey.dreambot_utils;

import org.dreambot.api.script.AbstractScript;

import java.util.HashMap;
import java.util.Map;

public class DreambotUtils {

    private static AbstractScript script;
    private static Map<String, Object> params;

    public static void setScript(AbstractScript instance) {
        log("Set AbstractScript instance");
        script = instance;
    }

    public static void setParams(Map<String, Object> instance) {
        AbstractScript.log("Set parameters instance");
        params = instance;
    }

    public static Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap();
        }
        return params;
    }

    public static AbstractScript getScript() {
        if (script == null) {
            throw new IllegalStateException("AbstractScript has not been set");
        }
        return script;
    }

    public static void log(String s) {
        AbstractScript.log("[DreambotUtils] " + s);
    }

}
