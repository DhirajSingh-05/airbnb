package com.airbnb1.airbnb1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Securityconfig {


    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


//        http.csrf().disable().cors().disable();
//        http.authorizeHttpRequests().anyRequest().permitAll();
        http.csrf().disable().cors().disable();
        http.authorizeHttpRequests().anyRequest().permitAll();


        return http.build();

    }
}
