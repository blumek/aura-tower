package com.tower.aura.rest.web.adapter.controller.metric.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tower.aura.api.metrics.model.ApiMetrics;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebMetricsResponse(@JsonProperty("id") String identifier,
                                     @JsonProperty("name") String name,
                                     @JsonProperty("deviceType") RestWebDeviceTypeResponse deviceTypeResponse,
                                     @JsonProperty("deviceData") Map<String, Object> deviceData) {
    public RestWebMetricsResponse {
        if (isBlank(identifier)) {
            throw new IllegalArgumentException("Id cannot be blank");
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

    public static RestWebMetricsResponse fromApiMetrics(ApiMetrics metrics) {
        return new RestWebMetricsResponse(
                metrics.identifier().value(),
                metrics.name().value(),
                RestWebDeviceTypeResponse.fromApiDeviceType(metrics.deviceType()),
                metrics.deviceData().asMap()
        );
    }
}
