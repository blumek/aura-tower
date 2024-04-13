package com.tower.aura.application.persistence.mongodb.adapter;

import org.springframework.data.mongodb.repository.MongoRepository;

interface SpringMongodbMetricsRepository extends MongoRepository<MetricsDocument, String> {
}
