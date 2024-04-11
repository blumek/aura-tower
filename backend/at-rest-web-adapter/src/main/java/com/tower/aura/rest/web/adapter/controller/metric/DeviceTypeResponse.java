package com.tower.aura.rest.web.adapter.controller.metric;

import com.tower.aura.api.metrics.ApiDeviceType;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record DeviceTypeResponse(String id, String name) {
    public DeviceTypeResponse {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    public static DeviceTypeResponse fromApiDeviceType(ApiDeviceType deviceType) {
        return new DeviceTypeResponse(
                deviceType.identifier().value(),
                deviceType.name().value()
        );
    }
}
