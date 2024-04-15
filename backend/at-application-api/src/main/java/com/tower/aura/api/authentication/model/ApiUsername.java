package com.tower.aura.api.authentication.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiUsername(String value) {
    public ApiUsername {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Username cannot be blank");
        }
    }
}
