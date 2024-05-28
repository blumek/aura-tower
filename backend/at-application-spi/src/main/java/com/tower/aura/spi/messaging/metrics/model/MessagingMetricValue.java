package com.tower.aura.spi.messaging.metrics.model;

public sealed abstract class MessagingMetricValue permits
        MessagingBooleanMetricValue,
        MessagingNumberMetricValue,
        MessagingStringMetricValue {
}
