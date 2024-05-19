package com.tower.aura.application.persistence.mongodb.adapter.place;

import com.tower.aura.spi.persistence.place.PlacePersistenceGateway;
import com.tower.aura.spi.persistence.place.PlacePersistenceReply;
import com.tower.aura.spi.persistence.place.PlacePersistenceRequest;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIcon;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceName;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class MongodbPlacePersistenceGateway implements PlacePersistenceGateway {
    private final MongodbPlaceRepository repository;

    MongodbPlacePersistenceGateway(MongodbPlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public PlacePersistenceReply persist(PlacePersistenceRequest placePersistenceRequest) {
        final var placeDocument = toPlaceDocument(placePersistenceRequest);
        return toPlacePersistenceReply(repository.save(placeDocument));
    }

    private PlaceDocument toPlaceDocument(PlacePersistenceRequest placePersistenceRequest) {
        return new PlaceDocument(
                UUID.randomUUID().toString(),
                placePersistenceRequest.placeName().value(),
                MongodbPlaceIcon.valueOf(placePersistenceRequest.placeIcon().name())
        );
    }

    private PlacePersistenceReply toPlacePersistenceReply(PlaceDocument placeDocument) {
        return new PlacePersistenceReply(
                new PersistencePlaceIdentifier(placeDocument.getIdentifier()),
                new PersistencePlaceName(placeDocument.getName()),
                PersistencePlaceIcon.valueOf(placeDocument.getIcon().name())
        );
    }
}
