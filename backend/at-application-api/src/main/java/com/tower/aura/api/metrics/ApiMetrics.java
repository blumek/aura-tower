package com.tower.aura.api.metrics;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiMetrics(String id, String name, ApiDeviceType deviceType, ApiDeviceData deviceData) {
    public ApiMetrics {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (deviceType == null) {
            throw new IllegalArgumentException("Device type cannot be null");
        }

        if (deviceData == null) {
            throw new IllegalArgumentException("Device data cannot be null");
        }
    }
}
