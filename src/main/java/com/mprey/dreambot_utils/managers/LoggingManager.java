package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.DreambotUtils;

public class LoggingManager {

    public static void logScriptStarted() {
        String name = DreambotUtils.getScript() != null ? DreambotUtils.getScript().getManifest().name() : "Unregistered";
        DreambotUtils.log(name + " script has started");
    }

    public static void logScriptExited() {
        String name = DreambotUtils.getScript() != null ? DreambotUtils.getScript().getManifest().name() : "Unregistered";
        DreambotUtils.log(name + " script has exited");
    }

}
