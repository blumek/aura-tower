package com.tower.aura.api.place;

import com.tower.aura.api.model.ApiUserIdentifier;

public record GetUserPlacesRequest(ApiUserIdentifier userIdentifier) {
    public GetUserPlacesRequest {
        if (userIdentifier == null) {
            throw new IllegalArgumentException("User identifier cannot be null");
        }
    }
}
