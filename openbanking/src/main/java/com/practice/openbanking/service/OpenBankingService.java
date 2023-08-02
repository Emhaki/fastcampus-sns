package com.practice.openbanking.service;

import com.practice.openbanking.dto.BankRequestToken;
import com.practice.openbanking.dto.BankResponseToken;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenBankingService {

    private final String useCode;
    private final String clientId;
    private final String client_secret;
    private static final  String redirect_uri = "http://localhost:8080/gotest";
    private final OpenBankApiClient openBankApiClient;
    public OpenBankingService(@Value("${openbanking.useCode}") String useCode,
                           @Value("${openbanking.client-id}") String clientId,
                           @Value("${openbanking.client-Secret}") String client_secret,
                           OpenBankApiClient openBankApiClient){
        this.useCode = useCode;
        this.clientId = clientId;
        this.client_secret = client_secret;
        this.openBankApiClient = openBankApiClient;
    }
    public BankResponseToken requestToken(BankRequestToken bankRequestToken) {
        bankRequestToken.setBankRequestToken(clientId,client_secret,redirect_uri,"authorization_code");
        return openBankApiClient.requestToken(bankRequestToken);
    }
}
