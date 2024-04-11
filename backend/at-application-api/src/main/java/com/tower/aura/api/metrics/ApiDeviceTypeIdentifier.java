package com.tower.aura.api.metrics;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiDeviceTypeIdentifier(String value) {
    public ApiDeviceTypeIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }
    }
}
