package com.tower.aura.application.persistence;

public interface MetricsPersistenceGateway {
    MetricsPersistenceReply persist(MetricsPersistenceRequest metricsPersistenceRequest);
}
