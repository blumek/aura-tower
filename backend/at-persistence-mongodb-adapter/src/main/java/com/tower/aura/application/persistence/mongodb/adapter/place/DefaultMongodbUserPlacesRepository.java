package com.tower.aura.application.persistence.mongodb.adapter.place;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DefaultMongodbUserPlacesRepository implements MongodbUserPlacesRepository {
    private final SpringMongodbUserPlacesRepository repository;

    DefaultMongodbUserPlacesRepository(SpringMongodbUserPlacesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> findUserPlaceIdentifiers(String userIdentifier) {
        return repository.findById(userIdentifier)
                .map(UserPlacesDocument::getPlaceIdentifiers)
                .orElseGet(List::of);
    }

    @Override
    public void addUserPlace(String userIdentifier, String placeIdentifier) {
        repository.findById(userIdentifier)
                .ifPresentOrElse(
                        userPlacesDocument -> repository.save(userPlacesDocument.addPlaceIdentifier(placeIdentifier)),
                        () -> repository.save(new UserPlacesDocument(userIdentifier, List.of(placeIdentifier)))
                );
    }
}
