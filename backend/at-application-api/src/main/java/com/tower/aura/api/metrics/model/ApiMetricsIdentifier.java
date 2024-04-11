package com.tower.aura.api.metrics.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiMetricsIdentifier(String value) {
    public ApiMetricsIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }
    }
}
