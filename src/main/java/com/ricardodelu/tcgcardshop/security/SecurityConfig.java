/* package com.ricardodelu.tcgcardshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/actuator/**").permitAll() // Allow actuator endpoints
                .requestMatchers("/cards/**").permitAll() // Allow card endpoints
                .anyRequest().authenticated()
            )
            .httpBasic(); // or .formLogin() if you prefer

        return http.build();
    }
}
 */