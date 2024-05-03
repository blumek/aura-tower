package com.tower.aura.service;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.tower.aura.service.authentication.jwt.AccessTokenVerifierFactory;
import com.tower.aura.service.authentication.jwt.JwtConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Clock;

import static com.auth0.jwt.algorithms.Algorithm.HMAC256;

@Configuration
public class ServiceConfiguration {
    @Bean
    Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    Algorithm algorithm(JwtConfiguration jwtConfiguration) {
        return HMAC256(jwtConfiguration.secret());
    }

    @Bean
    JWTVerifier accessTokenJwtVerifier(AccessTokenVerifierFactory accessTokenVerifierFactory) {
        return accessTokenVerifierFactory.create();
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
