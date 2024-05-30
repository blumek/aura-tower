package com.tower.aura.http.light.bulb.simulator.model;

public interface LightBulbRepository {
    LightBulb findLightBulbWithIdentifier(LightBulbIdentifier identifier);
    void save(LightBulb lightBulb);
}
