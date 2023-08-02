package com.practice.openbanking.controller;

import com.practice.openbanking.dto.BankRequestToken;
import com.practice.openbanking.dto.BankResponseToken;
import com.practice.openbanking.service.OpenBankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@RequiredArgsConstructor
@Controller
public class CommonController {

    private final OpenBankingService openBankingService;

    @Value("${openbanking.client-id}")
    private String clientId;

    @Value("${openbanking.client-Secret}")
    private String clientSecret;
    private String redirectUrl = "http://localhost:8080/test";

    @RequestMapping("/main")
    public String main(Model model) {

        model.addAttribute("redirectUrl", redirectUrl);
        model.addAttribute("clientId", clientId);
        return "main";
    }

    @GetMapping("/test")
    public BankResponseToken getToken(BankRequestToken bankRequestToken) {
        System.out.println("서비스 로직 실행됐어요");
        System.out.println(bankRequestToken);
        return openBankingService.requestToken(bankRequestToken);
    }

    @RequestMapping("/gotest")
    public String gotest(Model model) {
        System.out.println("여기는 고테스트입니다.");
        return "test";
    }


}
