package com.tower.aura.spi.persistence.metrics.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record PersistenceDeviceTypeName(String value) {
    public PersistenceDeviceTypeName {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
