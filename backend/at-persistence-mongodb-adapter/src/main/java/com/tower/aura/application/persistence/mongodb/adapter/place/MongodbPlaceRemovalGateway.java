package com.tower.aura.application.persistence.mongodb.adapter.place;

import com.tower.aura.spi.persistence.place.PlaceRemovalGateway;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;
import org.springframework.stereotype.Service;

@Service
class MongodbPlaceRemovalGateway implements PlaceRemovalGateway {
    private final MongodbPlaceRepository repository;

    MongodbPlaceRemovalGateway(MongodbPlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void removePlace(PersistencePlaceIdentifier placeIdentifier) {
        repository.removeByIdentifier(placeIdentifier.value());
    }
}
