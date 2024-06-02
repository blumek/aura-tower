package com.tower.aura.spi.persistence.metrics.model;

public record PersistenceDeviceType(PersistenceDeviceTypeIdentifier identifier,
                                    PersistenceDeviceTypeName name) {
    public PersistenceDeviceType {
        if (identifier == null) {
            throw new IllegalArgumentException("Device type value cannot be null");
        }

        if (name == null) {
            throw new IllegalArgumentException("Device type value cannot be null");
        }
    }
}
