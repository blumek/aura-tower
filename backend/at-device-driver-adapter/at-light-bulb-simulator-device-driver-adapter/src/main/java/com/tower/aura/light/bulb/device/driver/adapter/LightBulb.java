package com.tower.aura.light.bulb.device.driver.adapter;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record LightBulb(String identifier,
                        boolean isOn,
                        String hexColor) {
    public LightBulb {
        if (isBlank(identifier)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }

        if (isBlank(hexColor)) {
            throw new IllegalArgumentException("Hex color cannot be blank");
        }
    }
}
