package com.mprey.dreambot_utils.models;

public class MuleTrade {

    private int tradeId;
    private String account; // the mule account to send a trade request
    private int[] location;
    private int world;

    public MuleTrade(int tradeId, String account, int[] location, int world) {
        this.tradeId = tradeId;
        this.account = account;
        this.location = location;
        this.world = world;
    }

    public int getTradeId() {
        return tradeId;
    }

    public String getAccount() {
        return account;
    }

    public int[] getLocation() {
        return location;
    }

    public int getWorld() {
        return world;
    }
}
