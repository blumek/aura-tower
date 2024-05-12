package com.tower.aura.service.authentication.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tower.aura.api.authentication.model.ApiJsonWebToken;
import com.tower.aura.spi.authentication.jwt.RefreshTokenCreator;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.UUID;

public class DefaultRefreshTokenCreator implements RefreshTokenCreator {
    private final Algorithm algorithm;
    private final Clock clock;
    private final JwtExpirationTimePolicy refreshTokenExpirationTimePolicy;

    public DefaultRefreshTokenCreator(Algorithm algorithm,
                               Clock clock,
                               JwtExpirationTimePolicy refreshTokenExpirationTimePolicy) {
        this.algorithm = algorithm;
        this.clock = clock;
        this.refreshTokenExpirationTimePolicy = refreshTokenExpirationTimePolicy;
    }

    @Override
    public ApiJsonWebToken create() {
        final var now = ZonedDateTime.now(clock);
        final var refreshToken = JWT.create()
                .withClaim("token_type", "refresh_token")
                .withClaim("token_identifier", UUID.randomUUID().toString())
                .withIssuedAt(now.toInstant())
                .withExpiresAt(now.plus(refreshTokenExpirationTimePolicy.expirationTime()).toInstant())
                .sign(algorithm);
        return new ApiJsonWebToken(refreshToken);
    }
}
