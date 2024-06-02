package com.tower.aura.spi.persistence.metrics.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record PersistenceDeviceTypeIdentifier(String value) {
    public PersistenceDeviceTypeIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }
    }
}
