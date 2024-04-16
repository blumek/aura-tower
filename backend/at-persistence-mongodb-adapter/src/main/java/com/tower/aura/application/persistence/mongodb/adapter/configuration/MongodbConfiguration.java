package com.tower.aura.application.persistence.mongodb.adapter.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.tower.aura.application.persistence.mongodb.adapter")
class MongodbConfiguration {
}
