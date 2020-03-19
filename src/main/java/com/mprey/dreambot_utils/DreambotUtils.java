package com.mprey.dreambot_utils;

import com.mprey.dreambot_utils.managers.SocketManager;
import com.mprey.dreambot_utils.statics.Environment;
import io.socket.emitter.Emitter;
import org.dreambot.api.script.AbstractScript;

public class DreambotUtils {

    private static AbstractScript script;
    private static String uuid;
    private static Environment environment = Environment.DEVELOPMENT;

    public static void registerScript(AbstractScript instance, String _uuid, String env) {
        script = instance;
        uuid = _uuid;
        environment = Environment.valueOf(env.toUpperCase());

        log("Registered new script: " + script.getManifest().name() + " (" + environment.toString() + " - " + uuid + ")");

        SocketManager.connect();
        SocketManager.on("SHUTDOWN", new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                DreambotUtils.log("Got request: " + objects[0]);
            }
        });
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

    public static String getUUID() {
        if (uuid == null) {
            throw new IllegalStateException("UUID has not been set");
        }
        return uuid;
    }

    public static void log(String s) {
        AbstractScript.log("[DreambotUtils] " + s);
    }

}
