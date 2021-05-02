package com.starling.challengeProject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Optional;

import static java.util.Optional.of;

@Service
public class HttpService<T> {

    private final RestTemplate restTemplate;

    @Value("${starling.sandbox.baseUrl}")
    private String SANDBOX_BASE_URL;

    public HttpService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Optional<T> get(String customerToken, String url, ParameterizedTypeReference<T> type ) {
        HttpEntity request = new HttpEntity(getHeader(customerToken));
        return httpCall(url, request, type, HttpMethod.GET);
    }

    public Optional<T> put(String customerToken, String url, String body, ParameterizedTypeReference<T> type ) {
        HttpEntity<String> request = new HttpEntity<String>(body, getHeader(customerToken));
        return httpCall(url, request, type, HttpMethod.PUT);
    }

    private HttpHeaders getHeader(String customerToken) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.set("Authorization", customerToken);
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        return requestHeaders;
    }

    private Optional<T> httpCall(String url, HttpEntity request, ParameterizedTypeReference<T> type, HttpMethod method) {
        ResponseEntity<T> responseEntity = this.restTemplate.exchange
                (SANDBOX_BASE_URL + url, method, request, type);

        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            return of(responseEntity.getBody());
        } else {
            throw new RuntimeException("HttpService: error making call" +
                    responseEntity.getStatusCode() + " " + responseEntity.getBody());
        }
    }

}
