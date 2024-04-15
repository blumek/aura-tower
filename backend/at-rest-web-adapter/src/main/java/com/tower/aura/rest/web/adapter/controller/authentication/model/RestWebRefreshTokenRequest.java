package com.tower.aura.rest.web.adapter.controller.authentication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tower.aura.api.authentication.RefreshTokenRequest;
import com.tower.aura.api.authentication.model.ApiJsonWebToken;
import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebRefreshTokenRequest(@JsonProperty("accessToken") String accessToken,
                                         @JsonProperty("refreshToken") String refreshToken) {
    public RestWebRefreshTokenRequest {
        if (isBlank(accessToken)) {
            throw new IllegalArgumentException("Access token cannot be blank");
        }

        if (isBlank(refreshToken)) {
            throw new IllegalArgumentException("Refresh token cannot be blank");
        }
    }

    public RefreshTokenRequest toRefreshTokenRequest() {
        return new RefreshTokenRequest(
                new ApiJsonWebTokenPair(
                        new ApiJsonWebToken(accessToken),
                        new ApiJsonWebToken(refreshToken)
                )
        );
    }
}
