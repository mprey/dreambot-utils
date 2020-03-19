package com.mprey.dreambot_utils;

import com.mprey.dreambot_utils.statics.Environment;
import org.dreambot.api.script.AbstractScript;

public class DreambotUtils {

    private static AbstractScript script;
    private static Environment environment = Environment.DEVELOPMENT;

    public static void setScript(AbstractScript instance) {
        log("Set AbstractScript instance");
        script = instance;
    }

    public static void setEnvironment(String env) {
        environment = Environment.valueOf(env.toUpperCase());
        log("Set environment instance to " + environment.toString());
    }

    public static Environment getEnvironment() {
        return environment;
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
