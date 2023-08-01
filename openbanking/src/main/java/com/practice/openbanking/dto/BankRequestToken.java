package com.practice.openbanking.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class BankRequestToken {
    private String code;
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String grant_type;

    public void setBankRequestToken(String client_id, String client_secret, String redirect_uri, String grant_type) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.redirect_uri = redirect_uri;
        this.grant_type = grant_type;
    }

    public MultiValueMap<String, String> toMultiValueMap() {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("code",this.code);
        parameters.add("client_id",this.client_id);
        parameters.add("client_secret",this.client_secret);
        parameters.add("redirect_uri", this.redirect_uri);
        parameters.add("grant_type",this.grant_type);

        return parameters;
    }
}
