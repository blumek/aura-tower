package com.tower.aura.rest.web.adapter.controller.authentication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebJsonWebTokenPairResponse(@JsonProperty("accessToken") String accessToken,
                                              @JsonProperty("refreshToken") String refreshToken) {
    public RestWebJsonWebTokenPairResponse {
        if (isBlank(accessToken)) {
            throw new IllegalArgumentException("Access token cannot be blank");
        }

        if (isBlank(refreshToken)) {
            throw new IllegalArgumentException("Refresh token cannot be blank");
        }
    }

    public static RestWebJsonWebTokenPairResponse fromApiJsonWebTokenPair(ApiJsonWebTokenPair jsonWebTokenPair) {
        return new RestWebJsonWebTokenPairResponse(
                jsonWebTokenPair.accessToken().value(),
                jsonWebTokenPair.refreshToken().value()
        );
    }
}
