package com.tower.aura.http.light.bulb.simulator.controller;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ColorChangeRequest(String hexColor) {
    public ColorChangeRequest {
        if (isBlank(hexColor)) {
            throw new IllegalArgumentException("Hex Color cannot be blank");
        }
    }
}
