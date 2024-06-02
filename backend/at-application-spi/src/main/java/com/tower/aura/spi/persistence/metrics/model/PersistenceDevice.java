package com.tower.aura.spi.persistence.metrics.model;

public record PersistenceDevice(PersistenceDeviceIdentifier identifier,
                                PersistenceDeviceType type,
                                PersistenceDeviceData data) {
    public PersistenceDevice {
        if (identifier == null) {
            throw new IllegalArgumentException("Identifier cannot be null");
        }

        if (type == null) {
            throw new IllegalArgumentException("Device type cannot be null");
        }

        if (data == null) {
            throw new IllegalArgumentException("Device data cannot be null");
        }
    }
}
