package com.tower.aura.spi.messaging.metrics.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public final class MessagingStringMetricValue extends MessagingMetricValue {
    private final String value;

    public MessagingStringMetricValue(String value) {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Value cannot be blank");
        }

        this.value = value;
    }

    public String asString() {
        return value;
    }
}
