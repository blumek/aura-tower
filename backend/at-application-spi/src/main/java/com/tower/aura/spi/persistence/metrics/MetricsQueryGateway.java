package com.tower.aura.spi.persistence.metrics;

import com.tower.aura.spi.persistence.metrics.model.PersistenceMetrics;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;

import java.util.List;

public interface MetricsQueryGateway {
    List<PersistenceMetrics> findMetricsForPlace(PersistencePlaceIdentifier placeIdentifier);
}
