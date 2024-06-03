package com.tower.aura.messaging.websocket.adapter.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record WebSocketMetrics(@JsonProperty("id") String metricsIdentifier,
                               @JsonProperty("deviceData") Map<String, Object> deviceData) {
    public WebSocketMetrics {
        if (isBlank(metricsIdentifier)) {
            throw new IllegalArgumentException("Metrics identifier cannot be blank");
        }

        if (deviceData == null) {
            throw new IllegalArgumentException("Device data cannot be null");
        }
    }
}
