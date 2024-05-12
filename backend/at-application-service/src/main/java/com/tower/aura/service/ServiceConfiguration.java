package com.tower.aura.service;

import com.auth0.jwt.algorithms.Algorithm;
import com.tower.aura.service.authentication.RefreshTokenService;
import com.tower.aura.service.authentication.ValidateAccessTokenService;
import com.tower.aura.service.authentication.jwt.JwtConfiguration;
import com.tower.aura.service.authentication.jwt.JwtVerifierFactory;
import com.tower.aura.spi.authentication.jwt.JwtTokenPairCreator;
import org.springframework.beans.factory.annotation.Qualifier;
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
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    ValidateAccessTokenService validateAccessTokenService(@Qualifier("accessTokenVerifierFactory") JwtVerifierFactory accessTokenVerifierFactory) {
        return new ValidateAccessTokenService(accessTokenVerifierFactory.create());
    }

    @Bean
    RefreshTokenService refreshTokenService(@Qualifier("refreshTokenVerifierFactory") JwtVerifierFactory refreshTokenVerifierFactory,
                                            JwtTokenPairCreator jwtTokenPairCreator) {
        return new RefreshTokenService(refreshTokenVerifierFactory.create(), jwtTokenPairCreator);
    }
}
