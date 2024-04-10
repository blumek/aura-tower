package com.tower.aura.rest.web.adapter.controller.metric;

import com.tower.aura.api.metrics.ApiMetrics;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record MetricsResponse(String id, String name, DeviceTypeResponse deviceTypeResponse, Map<String, Object> deviceData) {
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

    public static MetricsResponse fromApiMetrics(ApiMetrics metrics ) {
        return new MetricsResponse(metrics.id(), metrics.name(), DeviceTypeResponse.fromApiDeviceType(metrics.deviceType()), metrics.deviceData().asMap());
    }
}
