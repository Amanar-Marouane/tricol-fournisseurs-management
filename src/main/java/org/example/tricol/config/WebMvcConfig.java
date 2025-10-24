package org.example.tricol.config;

import org.example.tricol.utils.Console;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebMvcConfig {
    public WebMvcConfig() {
        Console.header("WEB MVC CONFIGURATION");
    }
}
