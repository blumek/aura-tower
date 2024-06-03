package com.tower.aura.application.persistence.mongodb.adapter.metrics;

import com.tower.aura.spi.persistence.metrics.MetricsUpdateDataGateway;
import com.tower.aura.spi.persistence.metrics.MetricsUpdateDataRequest;
import com.tower.aura.spi.persistence.metrics.model.*;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
class MongodbMetricsUpdateDataGateway implements MetricsUpdateDataGateway {
    private final MongodbMetricsRepository repository;

    MongodbMetricsUpdateDataGateway(MongodbMetricsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void update(MetricsUpdateDataRequest metricsUpdateDataRequest) {
        final var metricsIdentifierAsString = metricsUpdateDataRequest.metricsId().value();
        final var metrics = repository.findByIdentifier(metricsIdentifierAsString)
                .orElseThrow(() -> new IllegalStateException("Metrics with identifier %s not found".formatted(metricsIdentifierAsString)));

        metrics.addMetrics(toMetricsMap(metricsUpdateDataRequest.metricsCollection()));
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
