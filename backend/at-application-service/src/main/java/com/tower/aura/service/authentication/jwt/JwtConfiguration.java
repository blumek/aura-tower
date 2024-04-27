package com.tower.aura.service.authentication.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfiguration {
    @Bean
    Algorithm algorithm() {
        return Algorithm.HMAC256("secret");
    }

    @Bean
    JWTVerifier jwtVerifier(Algorithm algorithm) {
        return JWT.require(algorithm).build();
    }
}
