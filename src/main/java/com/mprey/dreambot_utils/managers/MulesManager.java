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
        return getTradeStatus(old.getTradeId());
    }

    public static MuleTrade getTradeStatus(int id) {
        MuleTradeStatusRequest request = new MuleTradeStatusRequest(id);
        return APIManager.sendPOSTRequest(Endpoint.Mule.TRADE_STATUS.toString(), request, MuleTradeStatusResponse.class);
    }

    public static boolean setTradeSuccessful(MuleTrade trade, int amount) {
        return setTradeSuccessful(trade.getTradeId(), amount);
    }

    public static boolean setTradeSuccessful(int id, int amount) {
        MuleTradeSuccessRequest request = new MuleTradeSuccessRequest(id, amount);
        return APIManager.sendPOSTRequest(Endpoint.Mule.TRADE_SUCCESS.toString(), request, String.class).equals("Success");
    }

    public static boolean setTradeFailure(MuleTrade trade) {
        return setTradeFailure(trade.getTradeId());
    }

    public static boolean setTradeFailure(int id) {
        MuleTradeFailureRequest request = new MuleTradeFailureRequest(id);
        return APIManager.sendPOSTRequest(Endpoint.Mule.TRADES_FAILURE.toString(), request, String.class).equals("Success");
    }

}
