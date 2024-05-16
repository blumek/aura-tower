package com.tower.aura.rest.web.adapter.controller.place.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record CreatePlaceRequest(@JsonProperty("name") String name,
                                 @JsonProperty("icon") RestWebPlaceIcon icon) {
    public CreatePlaceRequest {
        if (isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (icon == null) {
            throw new IllegalArgumentException("Icon cannot be null");
        }
    }
}
