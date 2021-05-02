package com.starling.challengeProject.model.savingsGoal;

import java.util.Map;

public class SavingsGoalRequest {
    private String name;
    private String currency;
    private Map<String, String> target;
    private String base64EncodedPhoto;

    public SavingsGoalRequest(String name, String currency, Map<String, String> target, String base64EncodedPhoto) {
        this.name = name;
        this.currency = currency;
        this.target = target;
        this.base64EncodedPhoto = base64EncodedPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Map<String, String> getTarget() {
        return target;
    }

    public void setTarget(Map<String, String> target) {
        this.target = target;
    }

    public String getBase64EncodedPhoto() {
        return base64EncodedPhoto;
    }

    public void setBase64EncodedPhoto(String base64EncodedPhoto) {
        this.base64EncodedPhoto = base64EncodedPhoto;
    }
}
