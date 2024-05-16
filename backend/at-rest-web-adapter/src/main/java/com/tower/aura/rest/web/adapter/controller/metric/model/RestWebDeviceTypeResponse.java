package com.tower.aura.rest.web.adapter.controller.metric.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tower.aura.api.metrics.model.ApiDeviceType;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebDeviceTypeResponse(@JsonProperty("id") String identifier,
                                        @JsonProperty("name") String name) {
    public RestWebDeviceTypeResponse {
        if (identifier == null) {
            throw new IllegalArgumentException("Identifier cannot be null");
        }

        if (isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    public static RestWebDeviceTypeResponse fromApiDeviceType(ApiDeviceType deviceType) {
        return new RestWebDeviceTypeResponse(
                deviceType.identifier().value(),
                deviceType.name().value()
        );
    }
}
