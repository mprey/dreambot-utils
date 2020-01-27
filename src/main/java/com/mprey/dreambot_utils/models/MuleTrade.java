package com.mprey.dreambot_utils.models;

public class MuleTrade {

    private int tradeId;
    private String account; // the mule account to send a trade request
    private int[] location;
    private int world;
    private boolean completed;
    private boolean failed;

    public MuleTrade() {}

    public MuleTrade(int tradeId, String account, int[] location, int world, boolean completed, boolean failed) {
        this.tradeId = tradeId;
        this.account = account;
        this.location = location;
        this.world = world;
        this.completed = completed;
        this.failed = failed;
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

    public boolean isCompleted() {
        return completed;
    }

    public boolean isFailed() {
        return failed;
    }
}
