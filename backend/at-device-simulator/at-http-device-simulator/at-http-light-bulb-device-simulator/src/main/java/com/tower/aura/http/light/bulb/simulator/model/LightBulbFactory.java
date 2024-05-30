package com.tower.aura.http.light.bulb.simulator.model;

public class LightBulbFactory {
    public static LightBulb create() {
        return LightBulb.create(HexColor.of("#FAEBD7"));
    }
}
