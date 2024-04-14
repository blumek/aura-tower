package com.tower.aura.spi.persistence.metrics.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public final class PersistenceMetricsCollection {
    private final Map<String, PersistenceMetric> metrics;

    private PersistenceMetricsCollection(Map<String, PersistenceMetric> metrics) {
        if (metrics == null) {
            throw new IllegalArgumentException("Metrics cannot be null");
        }

        this.metrics = metrics;
    }

    public static PersistenceMetricsCollection fromMap(Map<String, PersistenceMetric> metrics) {
        return new PersistenceMetricsCollection(metrics);
    }

    public Stream<PersistenceMetric> asStream() {
        return metrics.values().stream();
    }

    public Collection<PersistenceMetric> asCollection() {
        return metrics.values();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        PersistenceMetricsCollection that = (PersistenceMetricsCollection) other;
        return Objects.equals(metrics, that.metrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metrics);
    }

    @Override
    public String toString() {
        return "MetricsCollection{" +
                "metrics=" + metrics +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final Map<String, PersistenceMetric> metrics = new HashMap<>();

        public Builder withMetric(PersistenceMetric metric) {
            this.metrics.put(metric.name(), metric);
            return this;
        }

        public PersistenceMetricsCollection build() {
            return new PersistenceMetricsCollection(Map.copyOf(metrics));
        }
    }
}
