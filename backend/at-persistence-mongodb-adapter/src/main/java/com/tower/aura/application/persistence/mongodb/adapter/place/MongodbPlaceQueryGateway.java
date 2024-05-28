package com.tower.aura.application.persistence.mongodb.adapter.place;

import com.tower.aura.spi.persistence.place.PlaceQueryGateway;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIcon;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceName;
import com.tower.aura.spi.persistence.place.model.PersistencePlace;
import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;
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
    public List<PersistencePlace> findUserPlaces(PersistenceUserIdentifier userIdentifier) {
        return placeRepository.findPlacesByIdentifiers(userPlacesRepository.findUserPlaceIdentifiers(userIdentifier.value()))
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
