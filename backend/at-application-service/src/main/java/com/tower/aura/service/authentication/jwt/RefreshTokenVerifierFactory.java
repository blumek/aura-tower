package com.tower.aura.service.authentication.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

@Component
class RefreshTokenVerifierFactory implements JwtVerifierFactory {
    private final Algorithm algorithm;

    RefreshTokenVerifierFactory(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public JWTVerifier create() {
        return JWT.require(algorithm)
                .withClaim("token_type", "refresh_token")
                .build();
    }
}
