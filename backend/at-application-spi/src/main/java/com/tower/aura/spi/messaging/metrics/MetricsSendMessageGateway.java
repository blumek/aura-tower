package com.tower.aura.spi.messaging.metrics;

public interface MetricsSendMessageGateway {
    void send(MetricsSendMessageRequest metricsSendMessageRequest);
}
