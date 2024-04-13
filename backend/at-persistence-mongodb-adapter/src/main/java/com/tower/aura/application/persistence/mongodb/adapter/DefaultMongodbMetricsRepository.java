package com.tower.aura.application.persistence.mongodb.adapter;

import java.util.Optional;

class DefaultMongodbMetricsRepository implements MongodbMetricsRepository {
    private final SpringMongodbMetricsRepository repository;

    DefaultMongodbMetricsRepository(SpringMongodbMetricsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<MetricsDocument> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public MetricsDocument save(MetricsDocument metricsDocument) {
        return repository.save(metricsDocument);
    }
}
