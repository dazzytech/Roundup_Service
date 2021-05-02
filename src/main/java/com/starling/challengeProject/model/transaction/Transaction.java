package com.starling.challengeProject.model.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

public class Transaction implements Serializable {

    @JsonProperty("sourceAmount")
    private Map<String, String> amount;

    @JsonProperty("direction")
    private String direction;

    private String roundedAmount;

    public String getRoundedAmount() {
        return roundedAmount;
    }

    public void setRoundedAmount(String roundedAmount) {
        this.roundedAmount = roundedAmount;
    }

    public Map<String, String> getAmount() {
        return amount;
    }

    public void setAmount(Map<String, String> amount) {
        this.amount = amount;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Transaction(Map<String, String> amount, String direction) {
        this.amount = amount;
        this.direction = direction;
    }

}
