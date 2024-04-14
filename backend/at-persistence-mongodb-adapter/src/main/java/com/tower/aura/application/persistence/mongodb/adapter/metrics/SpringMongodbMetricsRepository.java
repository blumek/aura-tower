package com.tower.aura.application.persistence.mongodb.adapter.metrics;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SpringMongodbMetricsRepository extends MongoRepository<MetricsDocument, String> {
}
