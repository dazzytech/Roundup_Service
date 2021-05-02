package com.starling.challengeProject.service;

import com.starling.challengeProject.model.account.Account;
import com.starling.challengeProject.model.account.AccountCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@Service
public class AccountsService {

    private final HttpService<AccountCollection> httpService;

    @Value("${starling.sandbox.accountsUrl}")
    private String SANDBOX_ACCOUNTS_URL;

    public AccountsService(HttpService<AccountCollection> httpService) {
        this.httpService = httpService;
    }

    public Account retrieveAccounts(String customerToken) {
        Optional<AccountCollection> response = httpService.get(customerToken, SANDBOX_ACCOUNTS_URL,
                ParameterizedTypeReference.forType(AccountCollection.class));

        if (response.isPresent()) {
            Optional<Account> primaryAccount = Arrays.stream(response.get().getAccounts()).filter
                    (x -> "PRIMARY".equals(x.getAccountType())).findFirst();
            if (primaryAccount.isPresent()) {
                return primaryAccount.get();
            } else {
                throw new RuntimeException("Account Service: no primary account present for customer.");
            }
        } else {
            throw new RuntimeException("Account Service: account not found for customer.");
        }
    }
}
