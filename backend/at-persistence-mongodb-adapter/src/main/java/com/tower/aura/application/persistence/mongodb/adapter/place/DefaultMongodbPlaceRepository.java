package com.tower.aura.application.persistence.mongodb.adapter.place;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DefaultMongodbPlaceRepository implements MongodbPlaceRepository {
    private final SpringMongodbPlaceRepository repository;

    DefaultMongodbPlaceRepository(SpringMongodbPlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PlaceDocument> findAll() {
        return repository.findAll();
    }

    @Override
    public List<PlaceDocument> findPlacesByIdentifiers(List<String> placeIdentifiers) {
        return repository.findAllById(placeIdentifiers);
    }

    @Override
    public PlaceDocument save(PlaceDocument placeDocument) {
        return repository.save(placeDocument);
    }

    @Override
    public void removeByIdentifier(String identifier) {
        repository.deleteById(identifier);
    }
}
