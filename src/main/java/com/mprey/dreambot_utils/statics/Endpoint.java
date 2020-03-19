package com.mprey.dreambot_utils.statics;

public class Endpoint {
    public enum Account {
        SET_BANNED("/set-banned"),
        INDEX("/"),
        CREATE("/create"),
        RETURN("/return"),
        REQUEST("/request"),
        ACTIVE("/active");

        private String endpoint;

        Account(String endpoint) {
            this.endpoint = endpoint;
        }

        public String toString() {
            return "/accounts" + this.endpoint;
        }
    }

    public enum Mule {
        INDEX("/"),
        REQUEST_ACCOUNT("/accounts/request"),
        RETURN_ACCOUNT("/accounts/return"),
        ACTIVE("/active"),
        TRADES("/trades"),
        TRADE_REQUEST("/trades/request"),
        TRADE_STATUS("/trades/status"),
        TRADE_SUCCESS("/trades/success"),
        TRADES_FAILURE("/trades/failure");

        private String endpoint;

        Mule(String endpoint) {
            this.endpoint = endpoint;
        }

        @Override
        public String toString() {
            return "/mules" + endpoint;
        }
    }

    public enum Slave {
        REQUEST_ACCOUNT("/accounts/request"),
        RETURN_ACCOUNT("/accounts/return"),
        START("/start"),
        KILL("/kill");

        private String endpoint;

        Slave(String endpoint) {
            this.endpoint = endpoint;
        }

        @Override
        public String toString() {
            return "/slaves" + endpoint;
        }
    }

    public enum Socket {
        SCRIPTS("/scripts");

        private String endpoint;

        Socket(String endpoint) {
            this.endpoint = endpoint;
        }

        @Override
        public String toString() {
            return endpoint;
        }
    }
}
