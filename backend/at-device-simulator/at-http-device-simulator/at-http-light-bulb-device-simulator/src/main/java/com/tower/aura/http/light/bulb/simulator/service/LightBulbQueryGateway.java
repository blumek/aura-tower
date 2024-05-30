package com.tower.aura.http.light.bulb.simulator.service;

import com.tower.aura.http.light.bulb.simulator.model.LightBulbIdentifier;
import com.tower.aura.http.light.bulb.simulator.model.LightBulbRepository;
import com.tower.aura.http.light.bulb.simulator.model.LightBulbSnapshot;

public class LightBulbQueryGateway {
    private final LightBulbRepository lightBulbRepository;

    public LightBulbQueryGateway(LightBulbRepository lightBulbRepository) {
        this.lightBulbRepository = lightBulbRepository;
    }

    public LightBulbSnapshot findLightBulbWithIdentifier(String lightBulbIdentifier) {
        return lightBulbRepository
                .findLightBulbWithIdentifier(new LightBulbIdentifier(lightBulbIdentifier))
                .toLightBulbSnapshot();
    }
}
