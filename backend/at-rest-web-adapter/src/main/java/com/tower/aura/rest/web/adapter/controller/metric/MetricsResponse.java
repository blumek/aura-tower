package com.tower.aura.rest.web.adapter.controller.metric;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tower.aura.api.metrics.ApiMetrics;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record MetricsResponse(@JsonProperty("id") String id,
                              @JsonProperty("name") String name,
                              @JsonProperty("deviceType") DeviceTypeResponse deviceTypeResponse,
                              @JsonProperty("deviceData") Map<String, Object> deviceData) {
    public MetricsResponse {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (deviceTypeResponse == null) {
            throw new IllegalArgumentException("Device type cannot be null");
        }

        if (deviceData == null) {
            throw new IllegalArgumentException("Device data cannot be null");
        }
    }

    public static MetricsResponse fromApiMetrics(ApiMetrics metrics) {
        return new MetricsResponse(
                metrics.identifier().value(),
                metrics.name().value(),
                DeviceTypeResponse.fromApiDeviceType(metrics.deviceType()),
                metrics.deviceData().asMap()
        );
    }
}
