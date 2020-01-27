package com.mprey.dreambot_utils;

import com.mprey.dreambot_utils.statics.Environment;
import org.dreambot.api.script.AbstractScript;

//@ScriptManifest(
//        name = "DreambotUtils",
//        description = "DreambotUtils",
//        version = 1.1,
//        author = "mprey",
//        category = Category.MISC
//)
public class DreambotUtils {

    private static AbstractScript script;
    private static Environment environment = Environment.DEVELOPMENT;

//    @Override
//    public void onStart() {
//    }
//
//    @Override
//    public int onLoop() {
//        return 1000;
//    }

    public static void setScript(AbstractScript instance) {
        log("Set AbstractScript instance");
        script = instance;
    }

    public static void setEnvironment(String env) {
        AbstractScript.log("Set environment instance");
        environment = Environment.valueOf(env.toUpperCase());
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
