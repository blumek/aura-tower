package com.tower.aura.spi.persistence.metrics.model;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public final class PersistenceDeviceData {
    private final Map<PersistenceMetricName, PersistenceMetricValue> metrics;

    private PersistenceDeviceData(Map<PersistenceMetricName, PersistenceMetricValue> metrics) {
        if (metrics == null) {
            throw new IllegalArgumentException("Metrics cannot be null");
        }

        this.metrics = metrics;
    }

    public static PersistenceDeviceData fromMap(Map<PersistenceMetricName, PersistenceMetricValue> metrics) {
        return new PersistenceDeviceData(metrics);
    }

    public Stream<PersistenceMetric> asStream() {
        return metrics.entrySet()
                .stream()
                .map(entry -> new PersistenceMetric(entry.getKey(), entry.getValue()));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        PersistenceDeviceData that = (PersistenceDeviceData) other;
        return Objects.equals(metrics, that.metrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metrics);
    }

    @Override
    public String toString() {
        return "PersistenceDeviceData{" +
                "metrics=" + metrics +
                '}';
    }
}
