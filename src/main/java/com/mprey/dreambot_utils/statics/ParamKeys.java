package com.mprey.dreambot_utils.statics;

public enum ParamKeys {
    ENVIRONMENT("environment"),
    WORLD("world"),
    ACCOUNT("account"),
    LOCATION("location");

    private String value;

    ParamKeys(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
