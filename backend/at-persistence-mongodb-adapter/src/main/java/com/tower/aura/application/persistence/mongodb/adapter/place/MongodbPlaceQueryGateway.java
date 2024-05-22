package com.tower.aura.application.persistence.mongodb.adapter.place;

import com.tower.aura.spi.persistence.place.PlaceQueryGateway;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIcon;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceName;
import com.tower.aura.spi.persistence.place.model.PersistencePlace;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class MongodbPlaceQueryGateway implements PlaceQueryGateway {
    private final MongodbUserPlacesRepository userPlacesRepository;
    private final MongodbPlaceRepository placeRepository;

    MongodbPlaceQueryGateway(MongodbUserPlacesRepository userPlacesRepository,
                             MongodbPlaceRepository placeRepository) {
        this.userPlacesRepository = userPlacesRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public List<PersistencePlace> findUserPlaces(String userIdentifier) {
        return placeRepository.findPlacesByIdentifiers(userPlacesRepository.findUserPlaceIdentifiers(userIdentifier))
                .stream()
                .map(this::toPlacePersistence)
                .toList();
    }

    private PersistencePlace toPlacePersistence(PlaceDocument placeDocument) {
        return new PersistencePlace(
                new PersistencePlaceIdentifier(placeDocument.getIdentifier()),
                new PersistencePlaceName(placeDocument.getName()),
                PersistencePlaceIcon.valueOf(placeDocument.getIcon().name())
        );
    }
}
