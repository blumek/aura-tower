package com.tower.aura.application.persistence.adapter;


import com.tower.aura.spi.persistence.*;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

class MongodbMetricsPersistenceGateway implements MetricsPersistenceGateway {
    private final MongodbMetricsRepository metricsRepository;

    public MongodbMetricsPersistenceGateway(MongodbMetricsRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }

    @Override
    public MetricsPersistenceReply persist(MetricsPersistenceRequest metricsPersistenceRequest) {
        final var metricsDocument = metricsRepository.findById(metricsPersistenceRequest.metricsId().asString())
                .orElseGet(() -> MetricsDocument.empty(metricsPersistenceRequest.metricsId().asString()))
                .addMetrics(asMap(metricsPersistenceRequest.metricsCollection()));

        metricsRepository.save(metricsDocument);

        return toMetricsPersistenceReply(metricsPersistenceRequest);
    }

    private Map<String, Object> asMap(MetricsCollection metricsCollection) {
        return metricsCollection.asStream()
                .collect(toMap(Metric::name, this::toValue));
    }

    private Object toValue(Metric metric) {
        return switch (metric) {
            case StringMetric stringMetric -> stringMetric.value();
            case NumberMetric numberMetric -> numberMetric.value();
            default -> throw new IllegalStateException("Unexpected value: " + metric);
        };
    }

    private MetricsPersistenceReply toMetricsPersistenceReply(MetricsPersistenceRequest metricsPersistenceRequest) {
        return new MetricsPersistenceReply(metricsPersistenceRequest.metricsId(), metricsPersistenceRequest.metricsCollection());
    }
}
