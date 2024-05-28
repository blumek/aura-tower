package com.tower.aura.spi.messaging.metrics.model;

public sealed class MessagingMetricValue permits
        MessagingBooleanMetricValue,
        MessagingNumberMetricValue,
        MessagingStringMetricValue {
}
