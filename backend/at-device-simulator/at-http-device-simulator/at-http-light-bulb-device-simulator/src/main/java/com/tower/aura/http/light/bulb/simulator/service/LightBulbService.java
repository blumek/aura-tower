package com.tower.aura.http.light.bulb.simulator.service;

import com.tower.aura.http.light.bulb.simulator.model.HexColor;
import com.tower.aura.http.light.bulb.simulator.model.LightBulbIdentifier;
import com.tower.aura.http.light.bulb.simulator.model.LightBulbRepository;
import org.springframework.stereotype.Service;

@Service
public class LightBulbService {
    private final LightBulbRepository lightBulbRepository;

    public LightBulbService(LightBulbRepository lightBulbRepository) {
        this.lightBulbRepository = lightBulbRepository;
    }

    public void turnOnLightBulb(String lightBulbIdentifier) {
        final var lightBulb = lightBulbRepository.findLightBulbWithIdentifier(new LightBulbIdentifier(lightBulbIdentifier));
        lightBulb.turnOn();
        lightBulbRepository.save(lightBulb);
    }

    public void turnOffLightBulb(String lightBulbIdentifier) {
        final var lightBulb = lightBulbRepository.findLightBulbWithIdentifier(new LightBulbIdentifier(lightBulbIdentifier));
        lightBulb.turnOff();
        lightBulbRepository.save(lightBulb);
    }

    public void changeColor(String lightBulbIdentifier, String hexColor) {
        final var lightBulb = lightBulbRepository.findLightBulbWithIdentifier(new LightBulbIdentifier(lightBulbIdentifier));
        lightBulb.changeColorTo(new HexColor(hexColor));
        lightBulbRepository.save(lightBulb);
    }
}
