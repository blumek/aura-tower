package com.tower.aura.api.metrics;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiDeviceType(String id, String name) {
    public ApiDeviceType {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
