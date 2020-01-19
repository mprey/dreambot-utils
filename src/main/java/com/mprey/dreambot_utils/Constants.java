package com.mprey.dreambot_utils;

public class Constants {

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

    public enum Environment {
        DEVELOPMENT("development", "http://localhost:3000/api/v1"),
        PRODUCTION("production", "https://dreambot-backend.herokuapp.com/api/v1");

        private String value, api;

        Environment(String value, String api) {
            this.value = value;
            this.api = api;
        }

        public String getAPI() {
            return this.api;
        }

        public String toString() {
            return this.value;
        }
    }

}
