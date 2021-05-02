package com.starling.challengeProject.model.savingsGoal;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SavingsGoal implements Serializable {
    @JsonProperty("savingsGoalUid")
    private String savingsGoalUid;

    private String transferUid;

    public String getSavingsGoalUid() {
        return savingsGoalUid;
    }

    public void setSavingsGoalUid(String savingsGoalUid) {
        this.savingsGoalUid = savingsGoalUid;
    }

    public String getTransferUid() {
        return transferUid;
    }

    public void setTransferUid(String transferUid) {
        this.transferUid = transferUid;
    }
}
