package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import java.util.Optional;

interface MongodbUserCredentialsRepository {
    Optional<UserCredentialsDocument> findByUsername(String username);
    boolean usernameExists(String username);
    UserCredentialsDocument save(UserCredentialsDocument userCredentialsDocument);
}
