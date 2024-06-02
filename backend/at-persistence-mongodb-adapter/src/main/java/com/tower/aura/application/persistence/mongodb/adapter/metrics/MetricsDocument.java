package com.tower.aura.application.persistence.mongodb.adapter.metrics;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document
public class MetricsDocument {
    @Id
    private String id;
    private final List<Map<String, Object>> metrics;

    private MetricsDocument(String id, List<Map<String, Object>> metrics) {
        this.id = id;
        this.metrics = metrics;
    }

    public static MetricsDocument empty(String id) {
        return new MetricsDocument(id, new ArrayList<>());
    }

    public String getId() {
        return id;
    }

    public List<Map<String, Object>> getMetrics() {
        return metrics;
    }

    public MetricsDocument addMetrics(Map<String, Object> metrics) {
        this.metrics.add(metrics);
        return this;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        MetricsDocument that = (MetricsDocument) other;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MetricsDocument{" +
                "id='" + id + '\'' +
                ", metrics=" + metrics +
                '}';
    }
}
