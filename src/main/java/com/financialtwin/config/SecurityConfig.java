package com.financialtwin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .csrf(csrf -> csrf.disable()) // Disable CSRF for APIs
                        .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/api/v1/kyc-data/**").permitAll() // Allow your API
                                .anyRequest().authenticated() // Everything else requires login
                        );
                return http.build();
        }
}