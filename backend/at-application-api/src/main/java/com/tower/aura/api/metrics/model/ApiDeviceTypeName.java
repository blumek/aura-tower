package com.tower.aura.api.metrics.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiDeviceTypeName(String value) {
    public ApiDeviceTypeName {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
