package com.tower.aura.http.light.bulb.simulator.controller;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record LightBulbResponse(String identifier,
                                boolean isOn,
                                String hexColor) {
    public LightBulbResponse {
        if (isBlank(identifier)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }

        if (isBlank(hexColor)) {
            throw new IllegalArgumentException("Hex color cannot be blank");
        }
    }
}
