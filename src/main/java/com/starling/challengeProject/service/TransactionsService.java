package com.starling.challengeProject.service;

import com.starling.challengeProject.model.RoundUpResponse;
import com.starling.challengeProject.model.account.Account;
import com.starling.challengeProject.model.transaction.Transaction;
import com.starling.challengeProject.model.transaction.Transactions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class TransactionsService {

    private final HttpService<Transactions> httpService;


    @Value("${starling.sandbox.transactionFeedUrl}")
    private String SANDBOX_TRANSACTIONS_URL;

    public TransactionsService(HttpService<Transactions> httpService) {
        this.httpService = httpService;
    }

    public RoundUpResponse roundUpTransactions(String customerToken, Account account) {
        DateTimeFormatter requestTimestampFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String today = LocalDateTime.now().format(requestTimestampFormat);
        String lastWeekToday = LocalDateTime.now().minus(1, ChronoUnit.WEEKS).format(requestTimestampFormat);

        String url = SANDBOX_TRANSACTIONS_URL
                .replace("{account_uid}", account.getAccountUid())
                .replace("{category_uid}", account.getDefaultCategory())
                .replace("{min_timestamp}", lastWeekToday)
                .replace("{max_timestamp}", today);

        Optional<Transactions> response = httpService.get(customerToken, url, ParameterizedTypeReference.forType(Transactions.class));

        if (response.isPresent()) {
            int roundUpAmountTotal = 0;
            for(Transaction transaction: response.get().getTransactions()) {
                if(transaction.getDirection().equals("OUT")) {
                    final Number amount = parseInt(transaction.getAmount().get("minorUnits"));
                    final Number roundUpAmount = 100 - (amount.intValue() % 100);
                    if (roundUpAmount.intValue() < 100) {
                        final Number newAmount = amount.intValue() + roundUpAmount.intValue();
                        transaction.setRoundedAmount(newAmount.toString());
                        roundUpAmountTotal += roundUpAmount.intValue();
                    }
                }
            }
            RoundUpResponse roundUpResponse = new RoundUpResponse(account, response.get(), roundUpAmountTotal);
            return roundUpResponse;
        } else {
            throw new RuntimeException("TransactionService: cannot retrieve transaction feed for account");
        }
    }
}
