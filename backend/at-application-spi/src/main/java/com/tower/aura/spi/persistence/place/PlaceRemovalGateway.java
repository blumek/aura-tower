package com.tower.aura.spi.persistence.place;

import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;

public interface PlaceRemovalGateway {
    void removePlace(PersistencePlaceIdentifier placeIdentifier);
}
