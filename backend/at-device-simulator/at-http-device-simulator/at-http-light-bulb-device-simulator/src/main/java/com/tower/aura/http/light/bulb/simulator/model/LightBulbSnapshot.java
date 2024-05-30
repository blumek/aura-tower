package com.tower.aura.http.light.bulb.simulator.model;

public record LightBulbSnapshot(LightBulbIdentifier identifier, boolean isOn, HexColor color) {
    public LightBulbSnapshot {
        if (identifier == null) {
            throw new IllegalArgumentException("Identifier cannot be null");
        }

        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }
    }
}
