package com.tower.aura.spi.messaging.metrics.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public final class MessagingMetricsCollection {
    private final Map<String, MessagingMetric> metrics;

    private MessagingMetricsCollection(Map<String, MessagingMetric> metrics) {
        if (metrics == null) {
            throw new IllegalArgumentException("Metrics cannot be null");
        }

        this.metrics = metrics;
    }

    public static MessagingMetricsCollection fromMap(Map<String, MessagingMetric> metrics) {
        return new MessagingMetricsCollection(metrics);
    }

    public Stream<MessagingMetric> asStream() {
        return metrics.values().stream();
    }

    public Collection<MessagingMetric> asCollection() {
        return metrics.values();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        MessagingMetricsCollection that = (MessagingMetricsCollection) other;
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
        private final Map<String, MessagingMetric> metrics = new HashMap<>();

        public Builder withMetric(MessagingMetric metric) {
            this.metrics.put(metric.metricName().value(), metric);
            return this;
        }

        public MessagingMetricsCollection build() {
            return new MessagingMetricsCollection(Map.copyOf(metrics));
        }
    }
}
