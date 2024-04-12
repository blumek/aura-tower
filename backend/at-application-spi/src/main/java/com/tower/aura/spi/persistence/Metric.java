package com.tower.aura.spi.persistence;

import static org.apache.commons.lang3.StringUtils.isBlank;

public sealed class Metric permits StringMetric, NumberMetric {
    private final String name;

    public Metric(String name) {
       if (isBlank(name)) {
           throw new IllegalArgumentException("Metric name cannot be blank");
       }

        this.name = name;
    }

    public String name() {
        return name;
    }
}
