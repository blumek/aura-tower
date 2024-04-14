package com.tower.aura.spi.persistence.metrics;

import com.tower.aura.spi.persistence.metrics.model.PersistenceMetricsCollection;
import com.tower.aura.spi.persistence.metrics.model.PersistenceMetricsIdentifier;

public record MetricsPersistenceRequest(PersistenceMetricsIdentifier metricsId,
                                        PersistenceMetricsCollection metricsCollection) {
    public MetricsPersistenceRequest {
        if (metricsId == null) {
            throw new IllegalArgumentException("Metrics identifier cannot be null");
        }

        if (metricsCollection == null) {
            throw new IllegalArgumentException("Metrics collection cannot be null");
        }
    }
}
