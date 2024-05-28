package com.tower.aura.spi.persistence.place;

import com.tower.aura.spi.persistence.place.model.PersistencePlaceIcon;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceName;
import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;

public record PlacePersistenceRequest(PersistencePlaceName placeName,
                                      PersistencePlaceIcon placeIcon,
                                      PersistenceUserIdentifier ownerIdentifier) {
    public PlacePersistenceRequest {
        if (placeName == null) {
            throw new IllegalArgumentException("Place name cannot be null");
        }

        if (placeIcon == null) {
            throw new IllegalArgumentException("Place icon cannot be null");
        }

        if (ownerIdentifier == null) {
            throw new IllegalArgumentException("Owner identifier cannot be null");
        }
    }
}
