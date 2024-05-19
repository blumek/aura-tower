package com.tower.aura.spi.persistence.place.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record PersistencePlaceIdentifier(String value) {
    public PersistencePlaceIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Place identifier cannot be blank");
        }
    }
}
