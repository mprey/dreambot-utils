package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.DreambotUtils;
import com.mprey.dreambot_utils.models.Account;
import org.dreambot.api.methods.RSLoginResponse;

public class LoginManager {

    public enum LoginResponse {
        SWITCH_WORLDS,
        SUCCESSFUL,
        SWITCH_ACCOUNTS,
        DISABLED,
        RESTART,
        UNABLE
    };

    public static LoginResponse login(Account account) {
        RSLoginResponse resp = DreambotUtils.getScript().getLoginUtility().login(account.getEmail(), account.getPassword());
        if (resp == null) {
            return LoginResponse.UNABLE;
        }

        switch (resp) {
            case LOGGED_IN:
                return LoginResponse.SUCCESSFUL;
            case TOO_MANY_ATTEMPTS: {
                DreambotUtils.getScript().sleep(10 * 1000); // sleep for 10 seconds
                return LoginResponse.UNABLE;
            }

            case UPDATED:
            case SERVER_UPDATED:
            case BAD_SESSION:
            case BAD_AUTH_CODE:
                return LoginResponse.RESTART;

            case PASSWORD_KNOWN:
            case DISABLED:
            case INVALID_LOGIN:
            case ACCOUNT_LOCKED: {
                AccountManager.setAccountBanned(account);
                return LoginResponse.DISABLED;
            }

            case FULL_WORLD:
            case CLOSED_BETA:
            case MEMBERS_AREA:
            case MEMBERS_WORLD:
                return LoginResponse.SWITCH_WORLDS;

            case ADDRESS_BLOCKED:
            case ALREADY_LOGGED_IN: {
                return LoginResponse.SWITCH_ACCOUNTS;
            }

            default:
                return LoginResponse.UNABLE;
        }
    }

}
