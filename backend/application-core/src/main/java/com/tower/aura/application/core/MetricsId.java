package com.tower.aura.application.core;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public final class MetricsId {
    private final String value;

    public MetricsId(String value) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("Id cannot be blank");
        }

        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        MetricsId metricsId = (MetricsId) other;
        return Objects.equals(value, metricsId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MetricsId{" +
                "value='" + value + '\'' +
                '}';
    }

    public String asString() {
        return value;
    }
}
