package com.starling.challengeProject.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Account implements Serializable {
    @JsonProperty("accountUid")
    private String accountUid;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("defaultCategory")
    private String defaultCategory;

    public Account(String accountUid, String accountType, String defaultCategory) {
        this.accountUid = accountUid;
        this.accountType = accountType;
        this.defaultCategory = defaultCategory;
    }

    public String getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(String accountUid) {
        this.accountUid = accountUid;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDefaultCategory() {
        return defaultCategory;
    }

    public void setDefaultCategory(String defaultCategory) {
        this.defaultCategory = defaultCategory;
    }
}
