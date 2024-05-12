package com.tower.aura.spi.persistence.user.authentication.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record PersistenceJsonWebToken(String value) {
    public PersistenceJsonWebToken {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Json web token cannot be blank");
        }
    }
}
