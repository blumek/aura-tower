package simulator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simulator.model.ThermometerSnapshot;
import simulator.service.ThermometerQueryGateway;

@RestController
@RequestMapping("/v1/thermometers")
public class ThermometerController {
    private final ThermometerQueryGateway thermometerQueryGateway;

    public ThermometerController(ThermometerQueryGateway thermometerQueryGateway) {
        this.thermometerQueryGateway = thermometerQueryGateway;
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<ThermometerResponse> getThermometer(@PathVariable String identifier) {
        final var thermometerSnapshot = thermometerQueryGateway.findThermometerWithIdentifier(identifier);
        return ResponseEntity.ok(toThermometerResponse(thermometerSnapshot));
    }

    private ThermometerResponse toThermometerResponse(ThermometerSnapshot thermometerSnapshot) {
        return new ThermometerResponse(
                thermometerSnapshot.identifier().value(),
                thermometerSnapshot.temperatureCelsius().value()
        );
    }
}
