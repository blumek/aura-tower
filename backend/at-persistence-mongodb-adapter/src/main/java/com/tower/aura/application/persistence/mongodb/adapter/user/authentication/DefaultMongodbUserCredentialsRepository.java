package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class DefaultMongodbUserCredentialsRepository implements MongodbUserCredentialsRepository {
    private final SpringMongodbUserCredentialsRepository repository;

    DefaultMongodbUserCredentialsRepository(SpringMongodbUserCredentialsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<UserCredentialsDocument> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public boolean usernameExists(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public UserCredentialsDocument save(UserCredentialsDocument userCredentialsDocument) {
        return repository.save(userCredentialsDocument);
    }
}
