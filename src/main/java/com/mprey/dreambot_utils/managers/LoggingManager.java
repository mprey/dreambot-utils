package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.DreambotUtils;

public class LoggingManager {

    public static void logScriptStarted() {
        String name = DreambotUtils.getScript().getManifest().name();
        DreambotUtils.log(name + " script has started");
    }

    public static void logScriptExited() {
        String name = DreambotUtils.getScript().getManifest().name();
        DreambotUtils.log(name + " script has exited");
    }

}
