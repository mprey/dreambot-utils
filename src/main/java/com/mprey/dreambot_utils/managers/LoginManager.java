package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.DreambotUtils;
import com.mprey.dreambot_utils.models.Account;
import org.dreambot.api.script.AbstractScript;

public class LoginManager {

    private Account account;

    public LoginManager(Account account) {
        this.account = account;
    }

    public boolean login() {
        AbstractScript script = DreambotUtils.getScript();
        // TODO
        return false;
    }

}
