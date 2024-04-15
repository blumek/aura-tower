package com.tower.aura.api.authentication.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiUserIdentifier(String value) {
    public ApiUserIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("User identifier cannot be blank");
        }
    }
}
