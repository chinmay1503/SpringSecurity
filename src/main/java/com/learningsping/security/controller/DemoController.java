package com.learningsping.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/Leaders")
    public String showLeaders() {
        return "leaders";
    }

    @GetMapping("/Systems")
    public String showSystems() {
        return "systems";
    }
}
