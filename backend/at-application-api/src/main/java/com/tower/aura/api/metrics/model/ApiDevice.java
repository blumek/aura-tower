package com.tower.aura.api.metrics.model;

public record ApiDevice(ApiDeviceIdentifier identifier,
                        ApiDeviceType type,
                        ApiDeviceData data) {
    public ApiDevice {
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
