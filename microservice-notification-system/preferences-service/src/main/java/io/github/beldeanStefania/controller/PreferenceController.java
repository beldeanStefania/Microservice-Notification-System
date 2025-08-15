package io.github.beldeanStefania.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/preferences")
public class PreferenceController {
    @GetMapping("/ping")
    public String ping() {
        return "ok";
    }
}

