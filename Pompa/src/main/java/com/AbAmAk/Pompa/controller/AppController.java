package com.AbAmAk.Pompa.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class AppController {
    @GetMapping("/account")
    public String accountHi(Model model, Authentication authentication) {
        if (authentication != null) {
            String username = authentication.getName();
            model.addAttribute("username", username);
        } else {
            model.addAttribute("message", "Welcome, Guest!");
        }
        return "account";
    }


}