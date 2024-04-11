package com.tower.aura.api.metrics.model;

public record ApiDeviceType(ApiDeviceTypeIdentifier identifier,
                            ApiDeviceTypeName name) {
    public ApiDeviceType {
        if (identifier == null) {
            throw new IllegalArgumentException("Device type value cannot be null");
        }

        if (name == null) {
            throw new IllegalArgumentException("Device type value cannot be null");
        }
    }
}
