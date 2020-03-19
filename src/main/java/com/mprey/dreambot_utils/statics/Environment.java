package com.mprey.dreambot_utils.statics;

public enum Environment {
    DEVELOPMENT("development", "http://localhost:3000"),
    PRODUCTION("production", "https://dreambot-backend.herokuapp.com");

    private String value, base;

    Environment(String value, String base) {
        this.value = value;
        this.base = base;
    }

    public String getAPI() {
        return this.base + "/api/v1";
    }

    public String getSocketURI() {
        return this.base;
    }

    public String toString() {
        return this.value;
    }
}
