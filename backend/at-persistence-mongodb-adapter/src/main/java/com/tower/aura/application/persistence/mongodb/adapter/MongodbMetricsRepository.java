package com.tower.aura.application.persistence.mongodb.adapter;

import java.util.Optional;

interface MongodbMetricsRepository {
    Optional<MetricsDocument> findById(String id);
    MetricsDocument save(MetricsDocument metricsDocument);
}
