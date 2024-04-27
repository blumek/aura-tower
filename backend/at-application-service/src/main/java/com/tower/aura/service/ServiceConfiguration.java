package com.tower.aura.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class ServiceConfiguration {
    @Bean
    Clock clock() {
        return Clock.systemUTC();
    }
}
