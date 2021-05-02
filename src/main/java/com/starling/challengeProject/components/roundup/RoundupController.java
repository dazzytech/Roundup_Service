package com.starling.challengeProject.components.roundup;

import com.starling.challengeProject.model.RoundUpResponse;
import com.starling.challengeProject.service.AccountsService;
import com.starling.challengeProject.service.SavingsGoalService;
import com.starling.challengeProject.service.TransactionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 */
@RestController
public class RoundupController {

    final private RoundupService roundupService;


    public RoundupController(RoundupService roundupService) {
        this.roundupService = roundupService;
    }

    @PostMapping("/round_up_account")
    public ResponseEntity<?> RoundUpAccount(@RequestHeader Map<String, String> header) {
        try{
            String customerToken = header.get("authorization");

            RoundUpResponse response = roundupService.performRoundUp(customerToken);

            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
