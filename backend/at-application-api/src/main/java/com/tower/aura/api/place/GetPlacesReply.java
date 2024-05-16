package com.tower.aura.api.place;

import com.tower.aura.api.metrics.model.ApiMetrics;
import com.tower.aura.api.place.model.ApiPlace;

import java.util.List;

public record GetPlacesReply(List<ApiPlace> places) {
    public GetPlacesReply {
        if (places == null) {
            throw new IllegalArgumentException("Places cannot be null");
        }
    }
}
