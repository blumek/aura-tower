package com.tower.aura.spi.messaging.metrics.model;

public final class MessagingNumberMetricValue extends MessagingMetricValue {
    private final Number value;

    public MessagingNumberMetricValue(Number value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        this.value = value;
    }

    public Number asNumber() {
        return value;
    }
}
