package com.tower.aura.spi.persistence.metrics;

public interface MetricsUpdateGateway {
    void update(MetricsUpdateRequest metricsUpdateRequest);
}
