package com.tower.aura.application.persistence.adapter;

import com.tower.aura.application.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryMetricsPersistenceGateway implements MetricsPersistenceGateway {
    private final Map<MetricsId, List<MetricsCollection>> metrics = new HashMap<>();

    @Override
    public MetricsPersistenceReply persist(MetricsPersistenceRequest metricsPersistenceRequest) {
        saveMetrics(metricsPersistenceRequest);

        return toMetricsPersistenceReply(metricsPersistenceRequest);
    }

    private void saveMetrics(MetricsPersistenceRequest metricsPersistenceRequest) {
        metrics.computeIfAbsent(metricsPersistenceRequest.metricsId(), metricsId -> new ArrayList<>())
                .add(metricsPersistenceRequest.metricsCollection());
    }

    private MetricsPersistenceReply toMetricsPersistenceReply(MetricsPersistenceRequest metricsPersistenceRequest) {
        return new MetricsPersistenceReply(metricsPersistenceRequest.metricsId(), metricsPersistenceRequest.metricsCollection());
    }
}
