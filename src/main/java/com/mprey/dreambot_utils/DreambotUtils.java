package com.mprey.dreambot_utils;

import com.mprey.dreambot_utils.managers.SocketManager;
import com.mprey.dreambot_utils.models.ParameterScript;
import com.mprey.dreambot_utils.statics.Environment;
import io.socket.emitter.Emitter;
import org.dreambot.api.script.AbstractScript;

public class DreambotUtils {

    private static ParameterScript script;

    public static void registerScript(ParameterScript instance) {
        script = instance;
        log("Registered new script: " + script.getManifest().name() + " ("
                + instance.getParams().getEnvironment() + " - " + instance.getParams().getUUID() + ")");
    }

    public static void registerSocket() {
        SocketManager.connect();
        SocketManager.on("SHUTDOWN", new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                DreambotUtils.log("Got request: " + objects[0]);
            }
        });
    }

    public static Environment getEnvironment() {
        return getScript().getParams().getEnvironment();
    }

    public static ParameterScript getScript() {
        if (script == null) {
            throw new IllegalStateException("AbstractScript has not been set");
        }
        return script;
    }

    public static void log(String s) {
        AbstractScript.log("[DreambotUtils] " + s);
    }

}
