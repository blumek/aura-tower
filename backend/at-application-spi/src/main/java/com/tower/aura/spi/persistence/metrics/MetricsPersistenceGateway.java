package com.tower.aura.spi.persistence.metrics;

public interface MetricsPersistenceGateway {
    MetricsPersistenceReply persist(MetricsPersistenceRequest metricsPersistenceRequest);
}
