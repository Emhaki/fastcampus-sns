package com.practice.openbanking;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name="feign", url="https://testapi.openbanking.or.kr")
//public interface OpenBankingFeign {
//    @PostMapping(
//            path = "/oauth/2.0/token",
//            consumes = "application/x-www-form-urlencoded",
//            produces = "application/json")
//    public TokenResponseDto requestToken(
//            @RequestParam("code") String code,
//            @RequestParam("client_id") String client_id,
//            @RequestParam("client_secret") String client_secret,
//            @RequestParam("redirect_uri") String redirect_uri,
//            @RequestParam("grant_type") String grant_type);
//}
