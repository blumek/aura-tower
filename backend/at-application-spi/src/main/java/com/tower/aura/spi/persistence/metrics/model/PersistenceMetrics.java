package com.tower.aura.spi.persistence.metrics.model;

public record PersistenceMetrics(PersistenceMetricsIdentifier metricsId,
                                 PersistenceMetricsName metricsName,
                                 PersistenceDevice device) {
    public PersistenceMetrics {
        if (metricsId == null) {
            throw new IllegalArgumentException("Metrics identifier cannot be null");
        }

        if (metricsName == null) {
            throw new IllegalArgumentException("Metrics name cannot be null");
        }

        if (device == null) {
            throw new IllegalArgumentException("Device cannot be null");
        }
    }
}
