package com.tower.aura.spi.persistence.metrics.model;

public record PersistenceMetrics(PersistenceMetricsIdentifier metricsId,
                                 PersistenceMetricsCollection metricsCollection) {
    public PersistenceMetrics {
        if (metricsId == null) {
            throw new IllegalArgumentException("Metrics identifier cannot be null");
        }

        if (metricsCollection == null) {
            throw new IllegalArgumentException("Metrics collection cannot be null");
        }
    }
}
