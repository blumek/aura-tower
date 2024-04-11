package com.tower.aura.api.auth.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiForgotPasswordIdentifier(String value) {
    public ApiForgotPasswordIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }
    }
}
