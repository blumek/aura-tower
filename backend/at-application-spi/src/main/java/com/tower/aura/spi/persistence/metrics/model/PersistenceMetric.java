package com.tower.aura.spi.persistence.metrics.model;

public record PersistenceMetric(PersistenceMetricName metricName,
                                PersistenceMetricValue metricValue) {
    public PersistenceMetric {
        if (metricName == null) {
            throw new IllegalArgumentException("Metric name cannot be null");
        }

        if (metricValue == null) {
            throw new IllegalArgumentException("Metric value cannot be null");
        }
    }
}
