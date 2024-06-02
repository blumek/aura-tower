package com.tower.aura.application.persistence.mongodb.adapter.metrics;

import com.tower.aura.spi.persistence.metrics.MetricsUpdateGateway;
import com.tower.aura.spi.persistence.metrics.MetricsUpdateRequest;
import com.tower.aura.spi.persistence.metrics.model.*;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
class MongodbMetricsUpdateGateway implements MetricsUpdateGateway {
    private final MongodbMetricsRepository repository;

    MongodbMetricsUpdateGateway(MongodbMetricsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void update(MetricsUpdateRequest metricsUpdateRequest) {
        final var metricsIdentifierAsString = metricsUpdateRequest.metricsId().value();
        final var metrics = repository.findByIdentifier(metricsIdentifierAsString)
                .orElseThrow(() -> new IllegalStateException("Metrics with identifier %s not found".formatted(metricsIdentifierAsString)));

        metrics.addMetrics(toMetricsMap(metricsUpdateRequest.metricsCollection()));
        repository.save(metrics);
    }

    private Map<String, Object> toMetricsMap(PersistenceDeviceData persistenceDeviceData) {
        return persistenceDeviceData.asStream()
                .collect(toMap(this::toName, this::toValue));
    }

    private String toName(PersistenceMetric persistenceMetric) {
        return persistenceMetric.metricName().value();
    }

    private Object toValue(PersistenceMetric persistenceMetric) {
        return switch (persistenceMetric.metricValue()) {
            case PersistenceBooleanMetricValue booleanMetricValue -> booleanMetricValue.asBoolean();
            case PersistenceNumberMetricValue numberMetricValue -> numberMetricValue.asNumber();
            case PersistenceStringMetricValue stringMetricValue -> stringMetricValue.asString();
        };
    }
}
