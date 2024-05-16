package com.tower.aura.api.metrics.model;

public record ApiMetrics(ApiMetricsIdentifier identifier,
                         ApiMetricsName name,
                         ApiDevice device) {
    public ApiMetrics {
        if (identifier == null) {
            throw new IllegalArgumentException("Metrics value cannot be null");
        }

        if (name == null) {
            throw new IllegalArgumentException("Metrics value cannot be null");
        }

        if (device == null) {
            throw new IllegalArgumentException("Device cannot be null");
        }
    }
}
