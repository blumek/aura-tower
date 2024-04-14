package com.tower.aura.spi.persistence.metrics.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record PersistenceMetricsIdentifier(String value) {
    public PersistenceMetricsIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Metrics identifier cannot be blank");
        }
    }
}
