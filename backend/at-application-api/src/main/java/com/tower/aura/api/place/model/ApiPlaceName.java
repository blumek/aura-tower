package com.tower.aura.api.place.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiPlaceName(String value) {
    public ApiPlaceName {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
