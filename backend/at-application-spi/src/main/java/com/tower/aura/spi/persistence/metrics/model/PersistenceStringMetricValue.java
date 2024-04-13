package com.tower.aura.spi.persistence.metrics.model;

public final class PersistenceStringMetricValue extends PersistenceMetricValue {
    private final String value;

    private PersistenceStringMetricValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("String metric value cannot be null");
        }

        this.value = value;
    }

    public static PersistenceStringMetricValue fromString(String value) {
        return new PersistenceStringMetricValue(value);
    }

    public String asString() {
        return value;
    }
}
