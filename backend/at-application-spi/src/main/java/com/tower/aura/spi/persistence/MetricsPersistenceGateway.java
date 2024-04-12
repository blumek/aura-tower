package com.tower.aura.spi.persistence;

public interface MetricsPersistenceGateway {
    MetricsPersistenceReply persist(MetricsPersistenceRequest metricsPersistenceRequest);
}
