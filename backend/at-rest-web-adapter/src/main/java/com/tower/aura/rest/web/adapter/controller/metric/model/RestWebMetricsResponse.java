package com.tower.aura.rest.web.adapter.controller.metric.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tower.aura.api.metrics.model.ApiMetrics;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebMetricsResponse(@JsonProperty("id") String identifier,
                                     @JsonProperty("name") String name,
                                     @JsonProperty("device") RestWebDeviceResponse device) {
    public RestWebMetricsResponse {
        if (isBlank(identifier)) {
            throw new IllegalArgumentException("Id cannot be blank");
        }

        if (isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (device == null) {
            throw new IllegalArgumentException("Device cannot be null");
        }
    }

    public static RestWebMetricsResponse fromApiMetrics(ApiMetrics metrics) {
        return new RestWebMetricsResponse(
                metrics.identifier().value(),
                metrics.name().value(),
                RestWebDeviceResponse.fromApiDevice(metrics.device())
        );
    }
}
