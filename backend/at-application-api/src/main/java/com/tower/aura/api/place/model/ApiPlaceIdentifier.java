package com.tower.aura.api.place.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiPlaceIdentifier(String value) {
    public ApiPlaceIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }
    }
}
