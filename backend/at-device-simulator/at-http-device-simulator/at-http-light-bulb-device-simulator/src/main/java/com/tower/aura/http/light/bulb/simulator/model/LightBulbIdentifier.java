package com.tower.aura.http.light.bulb.simulator.model;

import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record LightBulbIdentifier(String value) {
    public LightBulbIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Light bulb identifier cannot be blank");
        }
    }

    public static LightBulbIdentifier generate() {
        return new LightBulbIdentifier(UUID.randomUUID().toString());
    }
}
