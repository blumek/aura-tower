package com.tower.aura.spi.persistence.user.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record PersistenceUsername(String value) {
    public PersistenceUsername {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Username cannot be blank");
        }
    }
}
