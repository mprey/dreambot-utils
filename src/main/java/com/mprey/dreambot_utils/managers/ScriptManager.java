package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.DreambotUtils;

public class ScriptManager {

    public static void shutdown(String reason) {
        DreambotUtils.log("shutting down script: " + reason);

        // TODO send an endpoint notification saying we shut down

        System.exit(0);
    }

}
