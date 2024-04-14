package com.tower.aura.spi.persistence.user.auth.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record PersistencePassword(String value) {
    public PersistencePassword {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Password cannot be blank");
        }
    }
}
