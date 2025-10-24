package org.example.tricol.config;

import org.example.tricol.utils.Console;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "org.example.tricol")
@EnableJpaRepositories(basePackages = "org.example.tricol.repositories")
@EnableTransactionManagement // enable @Transactional
public class AppConfig {
    public AppConfig() {
        Console.header("TRICOL FOURNISSEURS MANAGEMENT - APP CONFIG");
    }
}
