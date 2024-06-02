package com.tower.aura.spi.persistence.place;

import com.tower.aura.spi.persistence.place.model.PersistencePlaceIcon;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceName;

public record PlacePersistenceReply(PersistencePlaceIdentifier placeIdentifier,
                                    PersistencePlaceName placeName,
                                    PersistencePlaceIcon placeIcon) {
    public PlacePersistenceReply {
        if (placeIdentifier == null) {
            throw new IllegalArgumentException("Place identifier cannot be null");
        }

        if (placeName == null) {
            throw new IllegalArgumentException("Place name cannot be null");
        }

        if (placeIcon == null) {
            throw new IllegalArgumentException("Place icon cannot be null");
        }
    }
}