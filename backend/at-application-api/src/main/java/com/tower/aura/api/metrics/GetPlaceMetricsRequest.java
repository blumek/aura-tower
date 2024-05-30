package com.tower.aura.api.metrics;

import com.tower.aura.api.place.model.ApiPlaceIdentifier;

public record GetPlaceMetricsRequest(ApiPlaceIdentifier placeIdentifier) {
    public GetPlaceMetricsRequest {
        if (placeIdentifier == null) {
            throw new IllegalArgumentException("Place identifier cannot be null");
        }
    }
}
