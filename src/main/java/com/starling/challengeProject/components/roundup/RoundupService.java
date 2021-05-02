package com.starling.challengeProject.components.roundup;

import com.starling.challengeProject.model.RoundUpResponse;
import com.starling.challengeProject.service.AccountsService;
import com.starling.challengeProject.service.SavingsGoalService;
import com.starling.challengeProject.service.TransactionsService;
import org.springframework.stereotype.Service;

@Service
public class RoundupService {

    final private AccountsService accountsService;

    final private TransactionsService transactionsService;

    final private SavingsGoalService savingsGoalService;

    public RoundupService(AccountsService accountsService, TransactionsService transactionsService, SavingsGoalService savingsGoalService) {
        this.accountsService = accountsService;
        this.transactionsService = transactionsService;
        this.savingsGoalService = savingsGoalService;
    }

    public RoundUpResponse performRoundUp(String customerToken) {

        RoundUpResponse response = new RoundUpResponse();

        response.setRoundUpAccount(accountsService.retrieveAccounts(customerToken));

        response = transactionsService.roundUpTransactions(customerToken,
                response.getRoundUpAccount());

        response.setSavingsGoal(savingsGoalService.createSavingsGoal(customerToken,
                response.getRoundUpAccount().getAccountUid(),
                response.getRoundUpTotal().toString()));

        return response;
    }

}
