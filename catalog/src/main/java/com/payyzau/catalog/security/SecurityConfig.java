package com.payyzau.catalog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csfr -> csfr.disable())
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("api/v1/catalog").permitAll()
                        .anyRequest().authenticated())
                        .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
