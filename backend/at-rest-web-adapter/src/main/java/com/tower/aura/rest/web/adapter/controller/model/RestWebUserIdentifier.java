package com.tower.aura.rest.web.adapter.controller.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebUserIdentifier(String value) {
    public RestWebUserIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("User identifier cannot be blank");
        }
    }
}
