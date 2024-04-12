package com.tower.aura.spi.persistence;

import java.util.Objects;

public final class Metrics {
    private final MetricsId metricsId;
    private final MetricsCollection metricsCollection;

    private Metrics(MetricsId metricsId, MetricsCollection metricsCollection) {
        if (metricsId == null) {
            throw new IllegalArgumentException("MetricsId cannot be null");
        }

        if (metricsCollection == null) {
            throw new IllegalArgumentException("MetricsCollection cannot be null");
        }

        this.metricsId = metricsId;
        this.metricsCollection = metricsCollection;
    }

    public static Metrics from(MetricsId metricsId, MetricsCollection metricsCollection) {
        return new Metrics(metricsId, metricsCollection);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Metrics metrics = (Metrics) other;
        return Objects.equals(metricsId, metrics.metricsId) && Objects.equals(metricsCollection, metrics.metricsCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metricsId, metricsCollection);
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "metricsId=" + metricsId +
                ", metricsCollection=" + metricsCollection +
                '}';
    }
}
