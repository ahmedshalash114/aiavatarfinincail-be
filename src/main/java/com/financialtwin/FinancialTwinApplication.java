package com.financialtwin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FinancialTwinApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinancialTwinApplication.class, args);
    }
} 