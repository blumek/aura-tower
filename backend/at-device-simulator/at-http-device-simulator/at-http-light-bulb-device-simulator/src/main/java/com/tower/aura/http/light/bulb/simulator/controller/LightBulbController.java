package com.tower.aura.http.light.bulb.simulator.controller;

import com.tower.aura.http.light.bulb.simulator.model.LightBulbSnapshot;
import com.tower.aura.http.light.bulb.simulator.service.LightBulbQueryGateway;
import com.tower.aura.http.light.bulb.simulator.service.LightBulbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/light-bulbs")
public class LightBulbController {
    private final LightBulbQueryGateway lightBulbQueryGateway;
    private final LightBulbService lightBulbService;

    public LightBulbController(LightBulbQueryGateway lightBulbQueryGateway, LightBulbService lightBulbService) {
        this.lightBulbQueryGateway = lightBulbQueryGateway;
        this.lightBulbService = lightBulbService;
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<LightBulbResponse> getLightBulb(@PathVariable String identifier) {
        final var lightBulbSnapshot = lightBulbQueryGateway.findLightBulbWithIdentifier(identifier);
        return ResponseEntity.ok(toLightBulbResponse(lightBulbSnapshot));
    }

    private LightBulbResponse toLightBulbResponse(LightBulbSnapshot lightBulbSnapshot) {
        return new LightBulbResponse(
                lightBulbSnapshot.identifier().value(),
                lightBulbSnapshot.isOn(),
                lightBulbSnapshot.color().value()
        );
    }

    @PostMapping("/{identifier}/turn-on")
    public ResponseEntity<?> turnOn(@PathVariable String identifier) {
        lightBulbService.turnOnLightBulb(identifier);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{identifier}/turn-off")
    public ResponseEntity<?> turnOff(@PathVariable String identifier) {
        lightBulbService.turnOffLightBulb(identifier);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{identifier}/change-color")
    public ResponseEntity<?> setColor(@PathVariable String identifier, @RequestBody ColorChangeRequest colorChangeRequest) {
        lightBulbService.changeColor(identifier, colorChangeRequest.hexColor());
        return ResponseEntity.ok().build();
    }
}
