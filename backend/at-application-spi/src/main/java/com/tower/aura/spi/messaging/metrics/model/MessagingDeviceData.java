package com.tower.aura.spi.messaging.metrics.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public final class MessagingDeviceData {
    private final Map<String, MessagingMetric> metrics;

    private MessagingDeviceData(Map<String, MessagingMetric> metrics) {
        if (metrics == null) {
            throw new IllegalArgumentException("Metrics cannot be null");
        }

        this.metrics = metrics;
    }

    public static MessagingDeviceData fromMap(Map<String, MessagingMetric> metrics) {
        return new MessagingDeviceData(metrics);
    }

    public Stream<MessagingMetric> asStream() {
        return metrics.values().stream();
    }

    public Collection<MessagingMetric> asCollection() {
        return metrics.values();
    }

    public Map<MessagingMetricName, MessagingMetricValue> asMap() {
        return metrics.values()
                .stream()
                .collect(toMap(MessagingMetric::metricName, MessagingMetric::metricValue));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        MessagingDeviceData that = (MessagingDeviceData) other;
        return Objects.equals(metrics, that.metrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metrics);
    }

    @Override
    public String toString() {
        return "MessagingDeviceData{" +
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

        public MessagingDeviceData build() {
            return new MessagingDeviceData(Map.copyOf(metrics));
        }
    }
}
