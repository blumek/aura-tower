package com.tower.aura.service.authentication.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

@Component
class AccessTokenVerifierFactory implements JwtVerifierFactory {
    private final Algorithm algorithm;

    AccessTokenVerifierFactory(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public JWTVerifier create() {
        return JWT.require(algorithm)
                .withClaim("token_type", "access_token")
                .build();
    }
}
