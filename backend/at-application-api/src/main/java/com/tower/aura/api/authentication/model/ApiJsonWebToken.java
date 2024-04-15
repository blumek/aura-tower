package com.tower.aura.api.authentication.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiJsonWebToken(String value) {
    public ApiJsonWebToken {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Value cannot be blank");
        }
    }
}
