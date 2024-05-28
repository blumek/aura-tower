package com.tower.aura.spi.messaging.metrics.model;

public record MessagingMetric(MessagingMetricName metricName,
                              MessagingMetricValue metricValue) {
    public MessagingMetric {
        if (metricName == null) {
            throw new IllegalArgumentException("Metric name cannot be null");
        }

        if (metricValue == null) {
            throw new IllegalArgumentException("Metric value cannot be null");
        }
    }
}
