package com.tower.aura.light.bulb.device.driver.adapter;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record Thermometer(String identifier,
                          double temperature) {
    public Thermometer {
        if (isBlank(identifier)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }
    }
}
