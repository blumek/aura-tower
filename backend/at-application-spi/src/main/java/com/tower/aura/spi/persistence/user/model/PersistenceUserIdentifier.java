package com.tower.aura.spi.persistence.user.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record PersistenceUserIdentifier(String value) {
    public PersistenceUserIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("User identifier cannot be blank");
        }
    }
}
