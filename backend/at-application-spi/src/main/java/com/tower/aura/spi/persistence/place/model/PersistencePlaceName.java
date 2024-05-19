package com.tower.aura.spi.persistence.place.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record PersistencePlaceName(String value) {
    public PersistencePlaceName {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Place name cannot be blank");
        }
    }
}
