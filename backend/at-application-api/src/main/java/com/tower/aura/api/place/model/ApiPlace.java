package com.tower.aura.api.place.model;

public record ApiPlace(ApiPlaceIdentifier identifier,
                       ApiPlaceName name,
                       ApiPlaceIcon icon) {
    public ApiPlace {
        if (identifier == null) {
            throw new IllegalArgumentException("Identifier cannot be null");
        }

        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        if (icon == null) {
            throw new IllegalArgumentException("Icon cannot be null");
        }
    }
}
