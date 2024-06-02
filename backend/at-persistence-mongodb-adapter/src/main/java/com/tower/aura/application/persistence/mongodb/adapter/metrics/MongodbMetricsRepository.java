package com.tower.aura.application.persistence.mongodb.adapter.metrics;

import java.util.Optional;

interface MongodbMetricsRepository {
    Optional<MetricsDocument> findByIdentifier(String metricsIdentifier);
    MetricsDocument save(MetricsDocument metricsDocument);
}
