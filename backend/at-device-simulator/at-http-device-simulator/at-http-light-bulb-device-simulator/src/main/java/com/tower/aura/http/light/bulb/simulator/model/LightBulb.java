package com.tower.aura.http.light.bulb.simulator.model;

public class LightBulb {
    private final LightBulbIdentifier identifier;
    private boolean isOn;
    private HexColor color;

    private LightBulb(LightBulbIdentifier identifier, boolean isOn, HexColor color) {
        this.identifier = identifier;
        this.isOn = isOn;
        this.color = color;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public void changeColorTo(HexColor color) {
        this.color = color;
    }

    public static LightBulb create(HexColor color) {
        return new LightBulb(LightBulbIdentifier.generate(), false, color);
    }
    public static LightBulb create(LightBulbIdentifier identifier, HexColor color) {
        return new LightBulb(identifier, false, color);
    }


    public LightBulbSnapshot toLightBulbSnapshot() {
        return new LightBulbSnapshot(identifier, isOn, color);
    }
}
