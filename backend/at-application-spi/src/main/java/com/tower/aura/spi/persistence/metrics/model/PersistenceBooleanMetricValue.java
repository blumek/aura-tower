package com.tower.aura.spi.persistence.metrics.model;

public final class PersistenceBooleanMetricValue extends PersistenceMetricValue {
    private final Boolean value;

    private PersistenceBooleanMetricValue(Boolean value) {
        if (value == null) {
            throw new IllegalArgumentException("Boolean metric value cannot be null");
        }

        this.value = value;
    }

    public static PersistenceBooleanMetricValue fromBoolean(Boolean value) {
        return new PersistenceBooleanMetricValue(value);
    }

    public Boolean asBoolean() {
        return value;
    }
}
