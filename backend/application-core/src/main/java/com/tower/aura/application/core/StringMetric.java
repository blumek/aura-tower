package com.tower.aura.application.core;

import java.util.Objects;

public final class StringMetric extends Metric {
    private final String value;

    private StringMetric(String name, String value) {
        super(name);
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        this.value = value;
    }

    public static StringMetric of(String name, String value) {
        return new StringMetric(name, value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        StringMetric that = (StringMetric) other;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "StringMetric{" +
                "value='" + value + '\'' +
                '}';
    }
}
