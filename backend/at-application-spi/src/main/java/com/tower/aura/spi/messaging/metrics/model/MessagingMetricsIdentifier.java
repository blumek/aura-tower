package com.tower.aura.spi.messaging.metrics.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record MessagingMetricsIdentifier(String value) {
    public MessagingMetricsIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Metrics identifier cannot be blank");
        }
    }
}
