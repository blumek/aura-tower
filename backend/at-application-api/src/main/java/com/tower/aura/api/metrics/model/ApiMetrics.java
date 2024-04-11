package com.tower.aura.api.metrics.model;

public record ApiMetrics(ApiMetricsIdentifier identifier,
                         ApiMetricsName name,
                         ApiDeviceType deviceType,
                         ApiDeviceData deviceData) {
    public ApiMetrics {
        if (identifier == null) {
            throw new IllegalArgumentException("Metrics value cannot be null");
        }

        if (name == null) {
            throw new IllegalArgumentException("Metrics value cannot be null");
        }

        if (deviceType == null) {
            throw new IllegalArgumentException("Device type cannot be null");
        }

        if (deviceData == null) {
            throw new IllegalArgumentException("Device data cannot be null");
        }
    }
}
