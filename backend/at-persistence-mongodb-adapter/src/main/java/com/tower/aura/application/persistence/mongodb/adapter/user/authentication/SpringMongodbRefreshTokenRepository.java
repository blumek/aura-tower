package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SpringMongodbRefreshTokenRepository extends MongoRepository<RefreshTokenDocument, String> {
}
