package com.tower.aura.service.mappers;

import com.tower.aura.api.metrics.model.*;
import com.tower.aura.spi.persistence.metrics.model.*;

import static java.util.stream.Collectors.toMap;

public class MetricsMapper {
    private MetricsMapper() {}

    public static ApiMetrics toApiMetrics(PersistenceMetrics persistenceMetrics) {
        return new ApiMetrics(
                new ApiMetricsIdentifier(persistenceMetrics.metricsId().value()),
                new ApiMetricsName(persistenceMetrics.metricsName().value()),
                toApiDevice(persistenceMetrics.device())
        );
    }

    private static ApiDevice toApiDevice(PersistenceDevice device) {
        return new ApiDevice(
                new ApiDeviceIdentifier(device.identifier().value()),
                toApiDeviceType(device.type()),
                toApiDeviceData(device.data())
        );
    }

    private static ApiDeviceType toApiDeviceType(PersistenceDeviceType deviceType) {
        return new ApiDeviceType(
                new ApiDeviceTypeIdentifier(deviceType.identifier().value()),
                new ApiDeviceTypeName(deviceType.name().value())
        );
    }

    private static ApiDeviceData toApiDeviceData(PersistenceDeviceData deviceData) {
        final var collectedDeviceData = deviceData.asStream()
                .collect(toMap(MetricsMapper::toName, MetricsMapper::toValue));
        return ApiDeviceData.of(collectedDeviceData);
    }

    private static String toName(PersistenceMetric persistenceMetric) {
        return persistenceMetric.metricName().value();
    }

    private static Object toValue(PersistenceMetric persistenceMetric) {
        return switch (persistenceMetric.metricValue()) {
            case PersistenceBooleanMetricValue booleanMetricValue -> booleanMetricValue.asBoolean();
            case PersistenceNumberMetricValue numberMetricValue -> numberMetricValue.asNumber();
            case PersistenceStringMetricValue stringMetricValue -> stringMetricValue.asString();
        };
    }
}
