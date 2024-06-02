package com.tower.aura.http.light.bulb.simulator.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

import static java.util.Locale.ROOT;

@Service
class LightBulbSimulationService {
    private final LightBulbService lightBulbService;

    LightBulbSimulationService(LightBulbService lightBulbService) {
        this.lightBulbService = lightBulbService;
    }

    @Scheduled(fixedDelay = 20000)
    void simulateTurnOn() {
        lightBulbService.turnOnLightBulb("0c2ba6c3-5c96-4df3-b008-c68ca92137d3");
    }

    @Scheduled(fixedDelay = 20000, initialDelay = 10000)
    void simulateTurnOff() {
        lightBulbService.turnOffLightBulb("0c2ba6c3-5c96-4df3-b008-c68ca92137d3");
    }

    @Scheduled(fixedDelay = 10000)
    void simulateChangeColor() {
        lightBulbService.changeColor("0c2ba6c3-5c96-4df3-b008-c68ca92137d3", randomHexColor());
    }

    private String randomHexColor() {
        int nextInt = new Random().nextInt(0xffffff + 1);
        return String.format("#%06x", nextInt).toUpperCase(ROOT);
    }
}
