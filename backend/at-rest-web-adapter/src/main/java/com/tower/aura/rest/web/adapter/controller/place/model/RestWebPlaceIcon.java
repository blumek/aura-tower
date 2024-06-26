package com.tower.aura.rest.web.adapter.controller.place.model;

import com.tower.aura.api.place.model.ApiPlaceIcon;

public enum RestWebPlaceIcon {
    HOME,
    OFFICE,
    GARAGE,
    OTHER;

    public static RestWebPlaceIcon fromApiPlaceIcon(ApiPlaceIcon placeIcon) {
        return RestWebPlaceIcon.valueOf(placeIcon.name());
    }
}
