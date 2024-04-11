package com.tower.aura.api.metrics.model;

import java.util.Map;

public final class ApiDeviceData {
    private final Map<String, Object> deviceData;

    private ApiDeviceData(Map<String, Object> deviceData) {
        if (deviceData == null) {
            throw new IllegalArgumentException("Device data cannot be null");
        }

        this.deviceData = Map.copyOf(deviceData);
    }

    public static ApiDeviceData empty() {
        return new ApiDeviceData(Map.of());
    }

    public static ApiDeviceData of(Map<String, Object> deviceData) {
        return new ApiDeviceData(deviceData);
    }

    public Map<String, Object> asMap() {
        return deviceData;
    }
}
