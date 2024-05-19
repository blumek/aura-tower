package com.tower.aura.api.place;

import com.tower.aura.api.place.model.ApiPlace;

import java.util.List;

public record GetUserPlacesReply(List<ApiPlace> places) {
    public GetUserPlacesReply {
        if (places == null) {
            throw new IllegalArgumentException("Places cannot be null");
        }
    }
}
