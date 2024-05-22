package com.tower.aura.application.persistence.mongodb.adapter.place;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SpringMongodbUserPlacesRepository extends MongoRepository<UserPlacesDocument, String> {
}
