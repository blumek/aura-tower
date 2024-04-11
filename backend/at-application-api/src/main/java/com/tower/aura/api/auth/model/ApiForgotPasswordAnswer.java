package com.tower.aura.api.auth.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiForgotPasswordAnswer(String value) {
    public ApiForgotPasswordAnswer {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Answer cannot be blank");
        }
    }
}
