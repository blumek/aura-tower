package com.tower.aura.api.place;

import com.tower.aura.api.model.ApiUserIdentifier;
import com.tower.aura.api.place.model.ApiPlaceIcon;
import com.tower.aura.api.place.model.ApiPlaceName;

public record CreatePlaceRequest(ApiPlaceName name,
                                 ApiPlaceIcon icon,
                                 ApiUserIdentifier ownerIdentifier) {
    public CreatePlaceRequest {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        if (icon == null) {
            throw new IllegalArgumentException("Icon cannot be null");
        }

        if (ownerIdentifier == null) {
            throw new IllegalArgumentException("Owner identifier cannot be null");
        }
    }
}
