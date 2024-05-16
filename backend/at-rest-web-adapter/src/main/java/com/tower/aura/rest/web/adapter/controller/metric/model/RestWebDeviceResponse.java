package com.tower.aura.rest.web.adapter.controller.metric.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tower.aura.api.metrics.model.ApiDevice;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebDeviceResponse(@JsonProperty("id") String identifier,
                                    @JsonProperty("type") RestWebDeviceTypeResponse deviceTypeResponse,
                                    @JsonProperty("data") Map<String, Object> deviceData) {
    public RestWebDeviceResponse {
        if (isBlank(identifier)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }

        if (deviceTypeResponse == null) {
            throw new IllegalArgumentException("Device type cannot be null");
        }

        if (deviceData == null) {
            throw new IllegalArgumentException("Device data cannot be null");
        }
    }

    public static RestWebDeviceResponse fromApiDevice(ApiDevice device) {
        return new RestWebDeviceResponse(
                device.identifier().value(),
                RestWebDeviceTypeResponse.fromApiDeviceType(device.type()),
                device.data().asMap()
        );
    }
}
