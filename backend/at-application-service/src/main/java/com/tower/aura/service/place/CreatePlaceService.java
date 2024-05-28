package com.tower.aura.service.place;

import com.tower.aura.api.place.CreatePlaceReply;
import com.tower.aura.api.place.CreatePlaceRequest;
import com.tower.aura.api.place.CreatePlaceUseCase;
import com.tower.aura.api.place.model.ApiPlace;
import com.tower.aura.api.place.model.ApiPlaceIcon;
import com.tower.aura.api.place.model.ApiPlaceIdentifier;
import com.tower.aura.api.place.model.ApiPlaceName;
import com.tower.aura.spi.persistence.place.PlacePersistenceGateway;
import com.tower.aura.spi.persistence.place.PlacePersistenceReply;
import com.tower.aura.spi.persistence.place.PlacePersistenceRequest;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIcon;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceName;
import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;
import org.springframework.stereotype.Service;

@Service
public class CreatePlaceService implements CreatePlaceUseCase {
    private final PlacePersistenceGateway placePersistenceGateway;

    CreatePlaceService(PlacePersistenceGateway placePersistenceGateway) {
        this.placePersistenceGateway = placePersistenceGateway;
    }

    @Override
    public CreatePlaceReply create(CreatePlaceRequest createPlaceRequest) {
        final var placePersistenceRequest = toPlacePersistenceRequest(createPlaceRequest);
        return toCreatePlaceReply(placePersistenceGateway.persist(placePersistenceRequest));
    }

    private PlacePersistenceRequest toPlacePersistenceRequest(CreatePlaceRequest createPlaceRequest) {
        return new PlacePersistenceRequest(
                new PersistencePlaceName(createPlaceRequest.name().value()),
                PersistencePlaceIcon.valueOf(createPlaceRequest.icon().name()),
                new PersistenceUserIdentifier(createPlaceRequest.ownerIdentifier().value())
        );
    }

    private CreatePlaceReply toCreatePlaceReply(PlacePersistenceReply placePersistenceReply) {
        return new CreatePlaceReply(new ApiPlace(
                new ApiPlaceIdentifier(placePersistenceReply.placeIdentifier().value()),
                new ApiPlaceName(placePersistenceReply.placeName().value()),
                ApiPlaceIcon.valueOf(placePersistenceReply.placeIcon().name())
        ));
    }
}
