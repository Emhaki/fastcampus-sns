package com.practice.openbanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping("/main")
    public String main(Model model) {

        model.addAttribute();
        return "main";
    }
}
