package com.tower.aura.spi.messaging.metrics.model;

public record MessagingMetrics(MessagingMetricsIdentifier metricsId,
                               MessagingMetricsCollection metricsCollection) {
    public MessagingMetrics {
        if (metricsId == null) {
            throw new IllegalArgumentException("Metrics identifier cannot be null");
        }

        if (metricsCollection == null) {
            throw new IllegalArgumentException("Metrics collection cannot be null");
        }
    }
}
