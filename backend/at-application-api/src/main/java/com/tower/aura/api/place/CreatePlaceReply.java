package com.tower.aura.api.place;

import com.tower.aura.api.place.model.ApiPlace;

public record CreatePlaceReply(ApiPlace place) {
    public CreatePlaceReply {
        if (place == null) {
            throw new IllegalArgumentException("Place cannot be null");
        }
    }
}
