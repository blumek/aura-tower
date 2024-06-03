package com.tower.aura.spi.persistence.metrics;

import com.tower.aura.spi.persistence.metrics.model.PersistenceDeviceData;
import com.tower.aura.spi.persistence.metrics.model.PersistenceMetricsIdentifier;

public record MetricsUpdateDataRequest(PersistenceMetricsIdentifier metricsId,
                                       PersistenceDeviceData metricsCollection) {
    public MetricsUpdateDataRequest {
        if (metricsId == null) {
            throw new IllegalArgumentException("Metrics identifier cannot be null");
        }

        if (metricsCollection == null) {
            throw new IllegalArgumentException("Metrics collection cannot be null");
        }
    }
}
