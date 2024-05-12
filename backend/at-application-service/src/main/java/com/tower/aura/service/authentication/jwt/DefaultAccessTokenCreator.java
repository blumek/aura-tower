package com.tower.aura.service.authentication.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tower.aura.api.authentication.model.ApiJsonWebToken;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreateRequest;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreator;

import java.time.Clock;
import java.time.ZonedDateTime;

public class DefaultAccessTokenCreator implements AccessTokenCreator {
    private final Algorithm algorithm;
    private final Clock clock;
    private final JwtExpirationTimePolicy accessTokenExpirationTimePolicy;

    public DefaultAccessTokenCreator(Algorithm algorithm,
                              Clock clock,
                              JwtExpirationTimePolicy accessTokenExpirationTimePolicy) {
        this.algorithm = algorithm;
        this.clock = clock;
        this.accessTokenExpirationTimePolicy = accessTokenExpirationTimePolicy;
    }

    @Override
    public ApiJsonWebToken create(AccessTokenCreateRequest accessTokenCreateRequest) {
        final var now = ZonedDateTime.now(clock);
        final var accessToken = JWT.create()
                .withClaim("token_type", "access_token")
                .withClaim("user_id", accessTokenCreateRequest.userIdentifier().value())
                .withClaim("username", accessTokenCreateRequest.username().value())
                .withIssuedAt(now.toInstant())
                .withExpiresAt(now.plus(accessTokenExpirationTimePolicy.expirationTime()).toInstant())
                .sign(algorithm);
        return new ApiJsonWebToken(accessToken);
    }
}
