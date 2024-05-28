package com.tower.aura.spi.messaging.metrics;

import com.tower.aura.spi.messaging.metrics.model.MessagingMetrics;

public record MetricsSendMessageRequest(MessagingMetrics metrics) {
    public MetricsSendMessageRequest {
        if (metrics == null) {
            throw new IllegalArgumentException("Metrics cannot be null");
        }
    }
}
