package com.tower.aura.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.tower.aura.service.authentication.jwt.JwtConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Clock;
import java.time.Duration;

import static com.auth0.jwt.algorithms.Algorithm.HMAC256;

@Configuration
public class ServiceConfiguration {
    @Bean
    Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    JwtConfiguration jwtConfiguration() {
        return new JwtConfiguration(
                "37c9a03777cf5bc55cd5894f579656ece6e5254b8f72afdeb4b44f2ac5f59e9ac3d015190a239b8104891348c8e7f26cc1858e6303cd3c0a03ec908080eef9358dd6a467fa9f778c6cf0db9bd2722dc9427e38d0ff99f5b8bbaf854d8a0cd6bad975079140bac2343dfb57235b3fcc64e578463132d8aeff6dc996831b121c2f",
                Duration.ofSeconds(20)
        );
    }

    @Bean
    Algorithm algorithm(JwtConfiguration jwtConfiguration) {
        return HMAC256(jwtConfiguration.secret());
    }

    @Bean
    JWTVerifier jwtVerifier(Algorithm algorithm) {
        return JWT.require(algorithm).build();
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
