package com.practice.openbanking.service;

import com.practice.openbanking.dto.BankRequestToken;
import com.practice.openbanking.dto.BankResponseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class OpenBankApiClient {
    private final RestTemplate restTemplate;
    private static final String base_url = "https://testapi.openbanking.or.kr/v2.0";

    public BankResponseToken requestToken(BankRequestToken bankRequestToken){
        HttpHeaders httpHeaders = generateHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        /**
         * 헤더의 컨텐트 타입이 application/x-www-form-urlencoded;charset=UTF-8이므로 객체를 집어넣을수 없음.. 그러므로 MultiValueMap 사용 해야함
         */
        HttpEntity httpEntity = generateHttpEntityWithBody(httpHeaders, bankRequestToken.toMultiValueMap());
        System.out.println("여기 실행됐어요!");
        System.out.println(httpEntity);
        System.out.println(restTemplate.exchange(base_url + "/token",HttpMethod.POST, httpEntity ,BankResponseToken.class).getBody());
        return restTemplate.exchange(base_url + "/token",HttpMethod.POST, httpEntity ,BankResponseToken.class).getBody();
    }
    private HttpEntity generateHttpEntityWithBody(HttpHeaders httpHeaders, MultiValueMap body) {
        return new HttpEntity<>(body, httpHeaders);
    }

    // 요청할 HttpEntity 생성
    private HttpEntity generateHttpEntity(HttpHeaders httpHeaders) {
        return new HttpEntity<>(httpHeaders);
    }

    //    헤더 생성
    private HttpHeaders generateHeader(String name, String val) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (name.equals("Authorization")) {
            httpHeaders.add(name, "Bearer" + val);
            return httpHeaders;
        }
        httpHeaders.add(name, val);
        return httpHeaders;
    }
}
