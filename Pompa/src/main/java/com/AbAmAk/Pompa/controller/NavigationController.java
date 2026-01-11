package com.AbAmAk.Pompa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class NavigationController {
    @GetMapping("/")
    public String home() {
        return "front";
    }

    @GetMapping("/oferta")
    public String ofertaPage() {
        return "oferta";
    }
}
