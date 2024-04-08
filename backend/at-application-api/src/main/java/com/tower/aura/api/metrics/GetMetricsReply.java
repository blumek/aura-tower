package com.tower.aura.api.metrics;

public record GetMetricsReply(ApiMetrics metrics) {
    public GetMetricsReply {
        if (metrics == null) {
            throw new IllegalArgumentException("Metrics cannot be null");
        }
    }
}
