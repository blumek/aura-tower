package com.tower.aura.rest.web.adapter.controller.authentication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tower.aura.api.authentication.LogInUserRequest;
import com.tower.aura.api.authentication.model.ApiPassword;
import com.tower.aura.api.authentication.model.ApiUsername;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebLogInRequest(@JsonProperty("username") String username,
                                  @JsonProperty("password") String password) {
    public RestWebLogInRequest {
        if (isBlank(username)) {
            throw new IllegalArgumentException("Username cannot be blank");
        }

        if (isBlank(password)) {
            throw new IllegalArgumentException("Password cannot be blank");
        }
    }

    public LogInUserRequest toLogInUserRequest() {
        return new LogInUserRequest(
                new ApiUsername(username),
                new ApiPassword(password)
        );
    }
}
