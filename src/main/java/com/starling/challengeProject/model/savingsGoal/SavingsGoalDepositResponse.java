package com.starling.challengeProject.model.savingsGoal;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SavingsGoalDepositResponse implements Serializable {

    @JsonProperty("transferUid")
    private String transferUid;

    @JsonProperty("success")
    private Boolean isSuccess;

    public String getTransferUid() {
        return transferUid;
    }

    public void setTransferUid(String transferUid) {
        this.transferUid = transferUid;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
