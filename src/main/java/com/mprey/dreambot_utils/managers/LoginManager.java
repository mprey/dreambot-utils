package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.DreambotUtils;
import com.mprey.dreambot_utils.models.Account;
import org.dreambot.api.methods.RSLoginResponse;

public class LoginManager {

    enum LoginResponse {
        SWITCH_WORLDS,
        SUCCESSFUL,
        SWITCH_ACCOUNTS
    };

    public static LoginResponse login(Account account) {
        RSLoginResponse resp = DreambotUtils.getScript().getLoginUtility().login(account.getEmail(), account.getPassword());

        switch (resp) {
            case LOGGED_IN: {
                return LoginResponse.SUCCESSFUL;
            }
            case DISABLED:
            case INVALID_LOGIN:
            case ACCOUNT_LOCKED: {
                // TODO send to API that the account is banned
                return LoginResponse.SWITCH_ACCOUNTS;
            }
            case FULL_WORLD:
            case CLOSED_BETA:
            case MEMBERS_AREA:
                return LoginResponse.SWITCH_WORLDS;
            default:
                return LoginResponse.SWITCH_ACCOUNTS;
        }
    }

}
