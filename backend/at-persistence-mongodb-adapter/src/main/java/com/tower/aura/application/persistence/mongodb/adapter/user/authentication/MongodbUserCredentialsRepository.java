package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

interface MongodbUserCredentialsRepository {
    boolean usernameExists(String username);
    UserCredentialsDocument save(UserCredentialsDocument userCredentialsDocument);
}
