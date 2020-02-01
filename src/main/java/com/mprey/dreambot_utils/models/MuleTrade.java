package com.mprey.dreambot_utils.models;

import org.dreambot.api.methods.map.Tile;

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

    public Tile getLocation() {
        return new Tile(location[0], location[1], location[2]);
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
