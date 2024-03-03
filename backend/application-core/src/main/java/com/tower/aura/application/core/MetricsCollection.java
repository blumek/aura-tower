package com.tower.aura.application.core;

import java.util.Map;

public final class MetricsCollection {
    private final Map<String, Metric> metrics;

    private MetricsCollection(Map<String, Metric> metrics) {
        this.metrics = metrics;
    }
}
