package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.models.MuleTrade;

public class MulesManager {

    public static MuleTrade requestTrade() {
        // TODO
        return new MuleTrade(1, "testAccount", new int[] {0, 0, 0}, 301);
    }

    public static void setTradeSuccessful(MuleTrade trade, int amount) {
        // TODO
    }

    public static void setTradeFailure(MuleTrade trade) {
        // TODO
    }

}
