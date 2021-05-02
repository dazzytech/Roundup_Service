package com.starling.challengeProject.model;

import com.starling.challengeProject.model.account.Account;
import com.starling.challengeProject.model.savingsGoal.SavingsGoal;
import com.starling.challengeProject.model.transaction.Transactions;

public class RoundUpResponse {
    private Account roundUpAccount;

    private SavingsGoal savingsGoal;

    private Number roundUpTotal;

    private Transactions transactions;

    public RoundUpResponse() {
    }

    public RoundUpResponse(Account roundUpAccount, Transactions transactions, Number roundUpTotal) {
        this.roundUpAccount = roundUpAccount;
        this.transactions = transactions;
        this.roundUpTotal = roundUpTotal;
    }

    public Account getRoundUpAccount() {
        return roundUpAccount;
    }

    public void setRoundUpAccount(Account roundUpAccount) {
        this.roundUpAccount = roundUpAccount;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    public Number getRoundUpTotal() {
        return roundUpTotal;
    }

    public void setRoundUpTotal(Number roundUpTotal) {
        this.roundUpTotal = roundUpTotal;
    }

    public SavingsGoal getSavingsGoal() {
        return savingsGoal;
    }

    public void setSavingsGoal(SavingsGoal savingsGoal) {
        this.savingsGoal = savingsGoal;
    }
}
