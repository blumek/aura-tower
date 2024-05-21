package com.tower.aura.service.place;

import com.tower.aura.api.place.RemovePlaceRequest;
import com.tower.aura.api.place.RemovePlaceUseCase;
import com.tower.aura.spi.persistence.place.PlaceRemovalGateway;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;
import org.springframework.stereotype.Service;

@Service
class RemovePlaceService implements RemovePlaceUseCase {
    private final PlaceRemovalGateway placeRemovalGateway;

    RemovePlaceService(PlaceRemovalGateway placeRemovalGateway) {
        this.placeRemovalGateway = placeRemovalGateway;
    }

    @Override
    public void remove(RemovePlaceRequest removePlaceRequest) {
        placeRemovalGateway.removePlace(toPersistencePlaceIdentifier(removePlaceRequest));
    }

    private PersistencePlaceIdentifier toPersistencePlaceIdentifier(RemovePlaceRequest removePlaceRequest) {
        return new PersistencePlaceIdentifier(removePlaceRequest.placeIdentifier().value());
    }
}
