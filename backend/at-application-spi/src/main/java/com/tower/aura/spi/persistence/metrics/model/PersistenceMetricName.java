package com.tower.aura.spi.persistence.metrics.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record PersistenceMetricName(String value) {
    public PersistenceMetricName {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Metric name cannot be blank");
        }
    }
}
