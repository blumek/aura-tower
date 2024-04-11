package com.tower.aura.api.metrics;

import com.tower.aura.api.metrics.model.ApiMetrics;

import java.util.List;

public record GetMetricsReply(List<ApiMetrics> metrics) {
    public GetMetricsReply {
        if (metrics == null) {
            throw new IllegalArgumentException("Metrics cannot be null");
        }
    }
}
