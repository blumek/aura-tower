package com.tower.aura.application.core;

import java.util.Objects;

public final class NumberMetric extends Metric {
    private final Number value;

    private NumberMetric(String name, Number value) {
        super(name);
        this.value = value;
    }

    public static NumberMetric of(String name, Number value) {
        return new NumberMetric(name, value);
    }

    public Number value() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        NumberMetric that = (NumberMetric) other;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "NumberMetric{" +
                "value=" + value +
                '}';
    }
}
