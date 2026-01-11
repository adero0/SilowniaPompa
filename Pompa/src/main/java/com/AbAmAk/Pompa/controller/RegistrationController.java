package com.AbAmAk.Pompa.controller;

import com.AbAmAk.Pompa.config.SecurityConfig;
import com.AbAmAk.Pompa.entity.AppUser;
import com.AbAmAk.Pompa.entity.enums.Role;
import com.AbAmAk.Pompa.service.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private final AppUserService appUserService;
    private final SecurityConfig securityConfig;

    public RegistrationController(AppUserService appUserService, SecurityConfig securityConfig) {
        this.appUserService = appUserService;
        this.securityConfig = securityConfig;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               Model model) {
        try {

            AppUser newUser = new AppUser();
            newUser.setUsername(username);
            newUser.setEmail(email);
            String hashedPassword = securityConfig.passwordEncoder().encode(password);
            newUser.setPassword(hashedPassword);
            newUser.setRole(Role.USER);
            appUserService.saveUser(newUser);

            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Registration failed. Please try again.");
            return "register";
        }
    }
}