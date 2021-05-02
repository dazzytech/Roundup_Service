package com.starling.challengeProject.model.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Transactions implements Serializable {
    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    @JsonProperty("feedItems")
    private Transaction[] transactions;
}
