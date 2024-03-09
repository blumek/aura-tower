package com.tower.aura.application.persistence.adapter;

import org.springframework.data.mongodb.repository.MongoRepository;

interface SpringMongodbMetricsRepository extends MongoRepository<MetricsDocument, String> {
}
