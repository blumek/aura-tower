package simulator.service;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import simulator.model.TemperatureCelsius;
import simulator.model.Thermometer;
import simulator.model.ThermometerIdentifier;
import simulator.model.ThermometerRepository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Scope("singleton")
class InMemoryThermometerRepository implements ThermometerRepository {
    private final Map<ThermometerIdentifier, Thermometer> thermometers = new HashMap<>();

    @PostConstruct
    public void bootstrap() {
        final var thermometer = Thermometer.create(new ThermometerIdentifier("48dcf7a9-780b-4e96-8414-a236c776a92f"), new TemperatureCelsius(10.0));
        save(thermometer);
    }

    @Override
    public Thermometer findThermometerWithIdentifier(ThermometerIdentifier identifier) {
        return thermometers.get(identifier);
    }

    @Override
    public void save(Thermometer thermometer) {
        thermometers.put(thermometer.toThermometerSnapshot().identifier(), thermometer);
    }
}
