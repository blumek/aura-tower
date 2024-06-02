package com.tower.aura.spi.persistence.metrics.model;

public sealed abstract class PersistenceMetricValue permits
        PersistenceBooleanMetricValue,
        PersistenceNumberMetricValue,
        PersistenceStringMetricValue {
}
