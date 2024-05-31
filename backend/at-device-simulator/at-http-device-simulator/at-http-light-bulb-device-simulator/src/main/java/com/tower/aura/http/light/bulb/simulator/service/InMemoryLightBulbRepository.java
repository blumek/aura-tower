package com.tower.aura.http.light.bulb.simulator.service;

import com.tower.aura.http.light.bulb.simulator.model.HexColor;
import com.tower.aura.http.light.bulb.simulator.model.LightBulb;
import com.tower.aura.http.light.bulb.simulator.model.LightBulbIdentifier;
import com.tower.aura.http.light.bulb.simulator.model.LightBulbRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Scope("singleton")
class InMemoryLightBulbRepository implements LightBulbRepository {
    private final Map<LightBulbIdentifier, LightBulb> lightBulbs = new HashMap<>();

    @PostConstruct
    public void bootstrap() {
        final var lightBulb = LightBulb.create(new LightBulbIdentifier("0c2ba6c3-5c96-4df3-b008-c68ca92137d3"), HexColor.of("#FAEBD7"));
        save(lightBulb);
    }

    @Override
    public LightBulb findLightBulbWithIdentifier(LightBulbIdentifier identifier) {
        return lightBulbs.get(identifier);
    }

    @Override
    public void save(LightBulb lightBulb) {
        lightBulbs.put(lightBulb.toLightBulbSnapshot().identifier(), lightBulb);
    }
}
