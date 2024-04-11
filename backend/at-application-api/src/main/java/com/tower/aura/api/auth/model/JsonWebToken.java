package com.tower.aura.api.auth.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record JsonWebToken(String value) {
    public JsonWebToken {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Value cannot be blank");
        }
    }
}
