package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.models.Account;
import com.mprey.dreambot_utils.models.MuleTrade;
import com.mprey.dreambot_utils.requests.MuleTradeFailureRequest;
import com.mprey.dreambot_utils.requests.MuleTradeRequestRequest;
import com.mprey.dreambot_utils.requests.MuleTradeStatusRequest;
import com.mprey.dreambot_utils.requests.MuleTradeSuccessRequest;
import com.mprey.dreambot_utils.responses.MuleTradeRequestResponse;
import com.mprey.dreambot_utils.responses.MuleTradeStatusResponse;
import com.mprey.dreambot_utils.statics.Endpoint;

public class MulesManager {

    public static MuleTrade requestTrade(Account account) {
        MuleTradeRequestRequest request = new MuleTradeRequestRequest(account.getUsername());
        return APIManager.sendPOSTRequest(Endpoint.Mule.TRADE_REQUEST.toString(), request, MuleTradeRequestResponse.class);
    }

    public static MuleTrade getTradeStatus(MuleTrade old) {
        MuleTradeStatusRequest request = new MuleTradeStatusRequest(old.getTradeId());
        return APIManager.sendPOSTRequest(Endpoint.Mule.TRADE_STATUS.toString(), request, MuleTradeStatusResponse.class);
    }

    public static boolean setTradeSuccessful(MuleTrade trade, int amount) {
        MuleTradeSuccessRequest request = new MuleTradeSuccessRequest(trade.getTradeId(), amount);
        return APIManager.sendPOSTRequest(Endpoint.Mule.TRADE_SUCCESS.toString(), request, String.class).equals("Success");
    }

    public static boolean setTradeFailure(MuleTrade trade) {
        MuleTradeFailureRequest request = new MuleTradeFailureRequest(trade.getTradeId());
        return APIManager.sendPOSTRequest(Endpoint.Mule.TRADES_FAILURE.toString(), request, String.class).equals("Success");
    }

}
