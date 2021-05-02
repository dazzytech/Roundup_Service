package com.starling.challengeProject.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    @JsonProperty("accountUid")
    private String accountUid;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("defaultCategory")
    private String defaultCategory;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("createdAt")
    private Date createdAt;
    @JsonProperty("name")
    private String name;

    public Account(String accountUid, String accountType, String defaultCategory, String currency, Date createdAt, String name) {
        this.accountUid = accountUid;
        this.accountType = accountType;
        this.defaultCategory = defaultCategory;
        this.currency = currency;
        this.createdAt = createdAt;
        this.name = name;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
