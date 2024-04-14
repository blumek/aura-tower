package com.tower.aura.application.persistence.mongodb.adapter.metrics;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class DefaultMongodbMetricsRepository implements MongodbMetricsRepository {
    private final SpringMongodbMetricsRepository repository;

    DefaultMongodbMetricsRepository(SpringMongodbMetricsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<MetricsDocument> findById(String identifier) {
        return repository.findById(identifier);
    }

    @Override
    public MetricsDocument save(MetricsDocument metricsDocument) {
        return repository.save(metricsDocument);
    }
}
