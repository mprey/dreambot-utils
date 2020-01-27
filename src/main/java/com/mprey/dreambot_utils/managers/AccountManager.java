package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.DreambotUtils;
import com.mprey.dreambot_utils.models.Account;
import com.mprey.dreambot_utils.requests.AccountCreateRequest;
import com.mprey.dreambot_utils.requests.AccountReturnRequest;
import com.mprey.dreambot_utils.requests.AccountSetBannedRequest;
import com.mprey.dreambot_utils.responses.AccountRequestResponse;
import com.mprey.dreambot_utils.statics.Endpoint;

public class AccountManager {

    public static Account requestAccount() {
        return APIManager.sendGETRequest(Endpoint.Account.REQUEST.toString(), AccountRequestResponse.class);
    }

    public static Account replaceAccount(Account old) {
        if (!returnAccount(old)) {
            DreambotUtils.log("Error trying to return account");
        }

        return requestAccount();
    }

    public static boolean setAccountBanned(Account account) {
        AccountSetBannedRequest request = new AccountSetBannedRequest(account.getUsername());
        String output = APIManager.sendPOSTRequest(Endpoint.Account.SET_BANNED.toString(), request, String.class);
        return output.equals("Success");
    }

    public static boolean returnAccount(Account account) {
        AccountReturnRequest request = new AccountReturnRequest(account.getUsername());
        String output = APIManager.sendPOSTRequest(Endpoint.Account.RETURN.toString(), request, String.class);
        return output.equals("Success");
    }

    public static boolean createAccount(Account account) {
        AccountCreateRequest request = new AccountCreateRequest(account);
        String output = APIManager.sendPOSTRequest(Endpoint.Account.CREATE.toString(), request, String.class);
        return output.equals("Success");
    }

}
