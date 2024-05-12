package com.tower.aura.service.authentication.jwt;

import com.auth0.jwt.JWTVerifier;

public interface JwtVerifierFactory {
    JWTVerifier create();
}
