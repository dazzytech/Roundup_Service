package com.starling.challengeProject.components.roundup;

import com.starling.challengeProject.model.RoundUpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RoundupController {

    final private RoundupService roundupService;

    public RoundupController(RoundupService roundupService) {
        this.roundupService = roundupService;
    }

    @GetMapping("/round_up_account")
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
