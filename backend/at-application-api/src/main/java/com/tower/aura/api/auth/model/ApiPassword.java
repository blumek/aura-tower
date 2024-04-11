package com.tower.aura.api.auth.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiPassword(String value) {
    public ApiPassword {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Password cannot be blank");
        }
    }
}
