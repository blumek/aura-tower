package com.tower.aura.spi.persistence.metrics.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record PersistenceMetricsName(String value) {
    public PersistenceMetricsName {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Metric name cannot be blank");
        }
    }
}
