package com.tower.aura.messaging.websocket.adapter.metrics;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record WebSocketMetrics(String metricsIdentifier,
                               Map<String, Object> deviceData) {
    public WebSocketMetrics {
        if (isBlank(metricsIdentifier)) {
            throw new IllegalArgumentException("Metrics identifier cannot be blank");
        }

        if (deviceData == null) {
            throw new IllegalArgumentException("Device data cannot be null");
        }
    }
}
