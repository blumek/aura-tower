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
    private final MongodbPlaceRepository placeRepository;
    private final MongodbUserPlacesRepository userPlacesRepository;

    MongodbPlacePersistenceGateway(MongodbPlaceRepository placeRepository,
                                   MongodbUserPlacesRepository userPlacesRepository) {
        this.placeRepository = placeRepository;
        this.userPlacesRepository = userPlacesRepository;
    }

    @Override
    public PlacePersistenceReply persist(PlacePersistenceRequest placePersistenceRequest) {
        final var placeDocument = toPlaceDocument(placePersistenceRequest);
        final var savedPlace = placeRepository.save(placeDocument);
        userPlacesRepository.addUserPlace(UUID.randomUUID().toString(), savedPlace.getIdentifier());
        return toPlacePersistenceReply(savedPlace);
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
