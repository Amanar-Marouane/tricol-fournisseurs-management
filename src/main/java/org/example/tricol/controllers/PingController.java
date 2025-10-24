package org.example.tricol.controllers;

import org.example.tricol.utils.Console;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    public PingController() {
        Console.header("PingController initialized");
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
