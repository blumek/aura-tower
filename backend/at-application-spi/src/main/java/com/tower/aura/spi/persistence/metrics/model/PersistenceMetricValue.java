package com.tower.aura.spi.persistence.metrics.model;

public sealed class PersistenceMetricValue permits
        PersistenceBooleanMetricValue,
        PersistenceNumberMetricValue,
        PersistenceStringMetricValue {
}
