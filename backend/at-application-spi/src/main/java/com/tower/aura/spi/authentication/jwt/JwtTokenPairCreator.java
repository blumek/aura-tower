package com.tower.aura.spi.authentication.jwt;

import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;

public interface JwtTokenPairCreator {
    ApiJsonWebTokenPair create(JwtCreateRequest jwtCreateRequest);
}
