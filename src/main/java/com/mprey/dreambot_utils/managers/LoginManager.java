package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.DreambotUtils;
import com.mprey.dreambot_utils.models.Account;
import org.dreambot.api.methods.RSLoginResponse;

public class LoginManager {

    public enum LoginResponse {
        SWITCH_WORLDS,
        SUCCESSFUL,
        SWITCH_ACCOUNTS,
        UNABLE
    };

    public static LoginResponse login(Account account) {
        RSLoginResponse resp = DreambotUtils.getScript().getLoginUtility().login(account.getEmail(), account.getPassword());
        if (resp == null) {
            return LoginResponse.UNABLE;
        }

        switch (resp) {
            case LOGGED_IN: {
                return LoginResponse.SUCCESSFUL;
            }
            case DISABLED:
            case INVALID_LOGIN:
            case ACCOUNT_LOCKED: {
                AccountManager.setAccountBanned(account);
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
