package com.tower.aura.spi.messaging.metrics.model;

public final class MessagingBooleanMetricValue extends MessagingMetricValue {
    private final boolean value;

    public MessagingBooleanMetricValue(Boolean value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        this.value = value;
    }

    public boolean asBoolean() {
        return value;
    }
}
