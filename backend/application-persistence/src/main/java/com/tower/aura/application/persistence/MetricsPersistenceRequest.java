package com.tower.aura.application.persistence;

import com.tower.aura.application.core.MetricsCollection;
import com.tower.aura.application.core.MetricsId;

public record MetricsPersistenceRequest(MetricsId metricsId, MetricsCollection metricsCollection) {
}
