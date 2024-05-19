package com.tower.aura.rest.web.adapter.controller.authentication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tower.aura.api.model.ApiUserIdentifier;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebRegisterResponse(@JsonProperty("userId") String userIdentifier) {
    public RestWebRegisterResponse {
        if (isBlank(userIdentifier)) {
            throw new IllegalArgumentException("User identifier cannot be blank");
        }
    }

    public static RestWebRegisterResponse fromApiUserIdentifier(ApiUserIdentifier userIdentifier) {
        return new RestWebRegisterResponse(userIdentifier.value());
    }
}
