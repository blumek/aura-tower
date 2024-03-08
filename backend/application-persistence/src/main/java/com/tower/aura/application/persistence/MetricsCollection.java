package com.tower.aura.application.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public final class MetricsCollection {
    private final Map<String, Metric> metrics;

    private MetricsCollection(Map<String, Metric> metrics) {
        if (metrics == null) {
            throw new IllegalArgumentException("Metrics cannot be null");
        }

        this.metrics = metrics;
    }

    public Stream<Metric> asStream() {
        return metrics.values().stream();
    }

    public Collection<Metric> asCollection() {
        return metrics.values();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        MetricsCollection that = (MetricsCollection) other;
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
        private final Map<String, Metric> metrics = new HashMap<>();

        public Builder withMetric(Metric metric) {
            this.metrics.put(metric.name(), metric);
            return this;
        }

        public MetricsCollection build() {
            return new MetricsCollection(Map.copyOf(metrics));
        }
    }
}
