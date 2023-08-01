package com.practice.openbanking.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class CommonController {

    @Value("${openbanking.client-id}")
    private String clientId;

    @Value("${openbanking.client-Secret}")
    private String clientSecret;
    private String redirectUrl = "http://localhost:8080/auth/openbank/callback";

    @RequestMapping("/main")
    public String main(Model model) {

        model.addAttribute("redirectUrl", redirectUrl);
        model.addAttribute("clientId", clientId);
        return "main";
    }

    @ResponseBody
    @PostMapping("/test")
    public void token(HashMap<String, Object> map) {
        System.out.println(map);
    }
}
