package com.tower.aura.application.persistence.mongodb.adapter.place;

import org.springframework.stereotype.Service;

@Service
class DefaultMongodbPlaceRepository implements MongodbPlaceRepository {
    private final SpringMongodbPlaceRepository repository;

    DefaultMongodbPlaceRepository(SpringMongodbPlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public PlaceDocument save(PlaceDocument placeDocument) {
        return repository.save(placeDocument);
    }
}
