package com.tower.aura.spi.authentication.jwt;

import com.tower.aura.api.authentication.model.ApiJsonWebToken;

public interface RefreshTokenCreator {
    ApiJsonWebToken create();
}
