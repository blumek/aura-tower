package com.tower.aura.spi.persistence.metrics.model;

public final class PersistenceNumberMetricValue extends PersistenceMetricValue {
    private final Number value;

    private PersistenceNumberMetricValue(Number value) {
        if (value == null) {
            throw new IllegalArgumentException("Number metric value cannot be null");
        }

        this.value = value;
    }

    public static PersistenceNumberMetricValue fromNumber(Number value) {
        return new PersistenceNumberMetricValue(value);
    }

    public Number asNumber() {
        return value;
    }
}
