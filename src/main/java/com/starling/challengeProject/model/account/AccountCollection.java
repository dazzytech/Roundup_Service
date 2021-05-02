package com.starling.challengeProject.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AccountCollection implements Serializable {
    @JsonProperty("accounts")
    private Account[] accounts;

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }
}
