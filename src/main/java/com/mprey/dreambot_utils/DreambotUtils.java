package com.mprey.dreambot_utils;

import org.dreambot.api.script.AbstractScript;

public class DreambotUtils {

    private static AbstractScript script;

    public static void setScript(AbstractScript instance) {
        script = instance;
    }

    public static AbstractScript getScript() {
        if (script == null) {
            throw new IllegalStateException("AbstractScript has not been set");
        }
        return script;
    }

}
