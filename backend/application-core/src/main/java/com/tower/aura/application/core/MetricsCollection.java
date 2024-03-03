package com.tower.aura.application.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public final class MetricsCollection {
    private final Map<String, Metric> metrics;

    private MetricsCollection(Map<String, Metric> metrics) {
        this.metrics = metrics;
    }

    public Stream<Metric> asStream() {
        return metrics.values().stream();
    }

    public Collection<Metric> asCollection() {
        return metrics.values();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Map<String, Metric> metrics = new HashMap<>();

        public Builder withMetric(Metric metric) {
            this.metrics.put(metric.name(), metric);
            return this;
        }

        public MetricsCollection build() {
            return new MetricsCollection(metrics);
        }
    }
}
