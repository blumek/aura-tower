package com.tower.aura.spi.messaging.metrics.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record MessagingMetricName(String value) {
    public MessagingMetricName {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Metric name cannot be blank");
        }
    }
}
