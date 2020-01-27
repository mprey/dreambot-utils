package com.mprey.dreambot_utils.requests;

public class MuleTradeSuccessRequest {
    private int tradeId;
    private int amount;

    public MuleTradeSuccessRequest(int tradeId, int amount) {
        this.tradeId = tradeId;
        this.amount = amount;
    }
}
