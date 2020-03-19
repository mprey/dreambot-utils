package com.mprey.dreambot_utils.models;

import com.mprey.dreambot_utils.helpers.JSON;
import com.mprey.dreambot_utils.managers.ScriptManager;
import org.dreambot.api.script.AbstractScript;

public abstract class ParameterScript<T extends BaseParams> extends AbstractScript {

    private static String SCRIPT_NAME;

    private T params;
    private boolean running = true;

    public ParameterScript() {
        SCRIPT_NAME = this.getManifest().name();
    }

    @Override
    public void onStart() {
        log("Script has started incorrectly. Must supply params via CLI.");
        ScriptManager.shutdown("No CLI parameters");
    }

    protected void loadParams(String raw, Class<T> clazz) {
        this.params = JSON.parseParams(raw, clazz);
    }

    public T getParams() {
        return params;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public static void log(String s) {
        AbstractScript.log("[" + SCRIPT_NAME + "] " + s);
    }

}
