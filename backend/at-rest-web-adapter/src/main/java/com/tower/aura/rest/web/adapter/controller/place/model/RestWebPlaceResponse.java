package com.tower.aura.rest.web.adapter.controller.place.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tower.aura.api.place.model.ApiPlace;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebPlaceResponse(@JsonProperty("id") String identifier,
                                   @JsonProperty("name") String name,
                                   @JsonProperty("icon") RestWebPlaceIcon icon) {
    public RestWebPlaceResponse {
        if (isBlank(identifier)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }

        if (isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (icon == null) {
            throw new IllegalArgumentException("Icon cannot be null");
        }
    }

    public static RestWebPlaceResponse fromApiPlace(ApiPlace place) {
        return new RestWebPlaceResponse(
                place.identifier().value(),
                place.name().value(),
                RestWebPlaceIcon.fromApiPlaceIcon(place.icon())
        );
    }
}
