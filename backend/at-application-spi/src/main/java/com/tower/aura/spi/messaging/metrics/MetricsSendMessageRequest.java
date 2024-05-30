package com.tower.aura.spi.messaging.metrics;

import com.tower.aura.spi.messaging.metrics.model.MessagingMetrics;
import com.tower.aura.spi.messaging.metrics.model.MessagingPlaceIdentifier;

public record MetricsSendMessageRequest(MessagingPlaceIdentifier messagingPlaceIdentifier, MessagingMetrics metrics) {
    public MetricsSendMessageRequest {
        if (messagingPlaceIdentifier == null) {
            throw new IllegalArgumentException("Place identifier cannot be null");
        }

        if (metrics == null) {
            throw new IllegalArgumentException("Metrics cannot be null");
        }
    }
}
