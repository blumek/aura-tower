package com.tower.aura.api.place;

import com.tower.aura.api.place.model.ApiPlaceIdentifier;

public record RemovePlaceRequest(ApiPlaceIdentifier placeIdentifier) {
    public RemovePlaceRequest {
        if (placeIdentifier == null) {
            throw new IllegalArgumentException("Place identifier cannot be null");
        }
    }
}
