package com.mprey.dreambot_utils.statics;

import com.google.gson.annotations.SerializedName;

public enum Environment {
    @SerializedName("development")
    DEVELOPMENT("http://localhost:3000"),
    @SerializedName("production")
    PRODUCTION("https://dreambot-backend.herokuapp.com");

    private String base;

    Environment(String base) {
        this.base = base;
    }

    public String getAPI() {
        return this.base + "/api/v1";
    }

    public String getSocketURI() {
        return this.base;
    }

    public String toString() {
        return this.name().toLowerCase();
    }
}
