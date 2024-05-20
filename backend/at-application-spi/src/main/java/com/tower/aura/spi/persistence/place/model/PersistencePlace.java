package com.tower.aura.spi.persistence.place.model;

public record PersistencePlace(PersistencePlaceIdentifier placeIdentifier,
                               PersistencePlaceName placeName,
                               PersistencePlaceIcon placeIcon) {
    public PersistencePlace {
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