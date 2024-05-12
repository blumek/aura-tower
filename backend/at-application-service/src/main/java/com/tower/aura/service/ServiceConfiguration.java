package com.tower.aura.service;

import com.auth0.jwt.algorithms.Algorithm;
import com.tower.aura.service.authentication.RefreshTokenService;
import com.tower.aura.service.authentication.ValidateAccessTokenService;
import com.tower.aura.service.authentication.jwt.*;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreator;
import com.tower.aura.spi.authentication.jwt.RefreshTokenCreator;
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
                                            AccessTokenCreator accessTokenCreator) {
        return new RefreshTokenService(refreshTokenVerifierFactory.create(), accessTokenCreator);
    }

    @Bean
    AccessTokenCreator accessTokenCreator(Algorithm algorithm,
                                          Clock clock,
                                          @Qualifier("configurationBasedAccessTokenExpirationTimePolicy") JwtExpirationTimePolicy accessTokenExpirationTimePolicy) {
        return new DefaultAccessTokenCreator(algorithm, clock, accessTokenExpirationTimePolicy);
    }

    @Bean
    RefreshTokenCreator refreshTokenCreator(Algorithm algorithm,
                                            Clock clock,
                                            @Qualifier("configurationBasedRefreshTokenExpirationTimePolicy") JwtExpirationTimePolicy refreshTokenExpirationTimePolicy) {
        return new DefaultRefreshTokenCreator(algorithm, clock, refreshTokenExpirationTimePolicy);
    }
}
