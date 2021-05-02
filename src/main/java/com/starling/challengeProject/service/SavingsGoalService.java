package com.starling.challengeProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starling.challengeProject.model.savingsGoal.SavingsGoal;
import com.starling.challengeProject.model.savingsGoal.SavingsGoalDeposit;
import com.starling.challengeProject.model.savingsGoal.SavingsGoalDepositResponse;
import com.starling.challengeProject.model.savingsGoal.SavingsGoalRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SavingsGoalService {
    private final HttpService<SavingsGoal> savingsGoalHttpService;

    private final HttpService<SavingsGoalDepositResponse> savingsGoalDepositResponseHttpService;

    ObjectMapper mapper = new ObjectMapper();

    @Value("${starling.sandbox.savingsCreateUrl}")
    private String SANDBOX_CREATE_SAVINGS_URL;

    @Value("${starling.sandbox.savingsAddUrl}")
    private String SANDBOX_DEPOSIT_INTO_SAVINGS_URL;

    public SavingsGoalService(HttpService<SavingsGoal> savingsGoalHttpService, HttpService<SavingsGoalDepositResponse> savingsGoalDepositResponseHttpService) {
        this.savingsGoalHttpService = savingsGoalHttpService;
        this.savingsGoalDepositResponseHttpService = savingsGoalDepositResponseHttpService;
    }

    public SavingsGoal createSavingsGoal(String customerToken, String accountUid, String roundUpTotal) {

        SavingsGoalRequest savingsGoalRequest = new SavingsGoalRequest(
                "Roundup Savings Goal",
                "GBP",
                Stream.of(new String[][]{{"currency", "GBP"},
                        {"minorUnits", "100000"}
                }).collect(Collectors.toMap(p -> p[0], p -> p[1])),
                "string"
        );
        String savingsGoalRequestBody;

        try {
            savingsGoalRequestBody = mapper.writeValueAsString(savingsGoalRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        String url = SANDBOX_CREATE_SAVINGS_URL
                .replace("{account_uid}", accountUid);

        Optional<SavingsGoal> response = savingsGoalHttpService.put
                (customerToken, url, savingsGoalRequestBody, ParameterizedTypeReference.forType(SavingsGoal.class));

        if (response.isPresent()) {
            if(response.get().getSuccessful()) {
                SavingsGoal savingsGoal = response.get();
                savingsGoal.setTransferUid(depositIntoSavingsGoal
                        (customerToken, accountUid, savingsGoal.getSavingsGoalUid(), roundUpTotal));
                return savingsGoal;
            } else {
                throw new RuntimeException("Error when making savings goal");
            }
        }
        else {
            throw new RuntimeException("Error when making savings goal");
        }
    }

    private String depositIntoSavingsGoal(String customerToken, String accountUid, String savingsUid, String roundUpTotal) {
        SavingsGoalDeposit savingsGoalDeposit = new SavingsGoalDeposit();
        savingsGoalDeposit.setAmount(Stream.of(new String[][]{{"currency", "GBP"},
                {"minorUnits", roundUpTotal}
        }).collect(Collectors.toMap(p -> p[0], p -> p[1])));
        String savingsGoalDepositString;
        UUID transferUid = UUID.fromString(accountUid);

        try {
            savingsGoalDepositString = mapper.writeValueAsString(savingsGoalDeposit);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        String url = SANDBOX_DEPOSIT_INTO_SAVINGS_URL
                .replace("{account_uid}", accountUid)
                .replace("{savings_goal_uid}", savingsUid)
                .replace("{transfer_uid}", transferUid.randomUUID().toString());

        Optional<SavingsGoalDepositResponse> response =
                this.savingsGoalDepositResponseHttpService.put(customerToken,
                        url, savingsGoalDepositString,
                        ParameterizedTypeReference.forType(SavingsGoalDepositResponse.class));

        if (response.isPresent()) {
            if(response.get().getIsSuccess()) {
                return response.get().getTransferUid();
            } else {
                throw new RuntimeException("Error when making savings goal");
            }
        } else {
            throw new RuntimeException("Error when making savings goal");
        }
    }
}
