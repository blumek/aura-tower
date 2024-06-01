package simulator.service;

import org.springframework.stereotype.Service;
import simulator.model.TemperatureCelsius;
import simulator.model.ThermometerIdentifier;
import simulator.model.ThermometerRepository;

@Service
public class ThermometerService {
    private final ThermometerRepository thermometerRepository;

    public ThermometerService(ThermometerRepository thermometerRepository) {
        this.thermometerRepository = thermometerRepository;
    }

    public void updateTemperature(String thermometerIdentifier, double temperature) {
        final var thermometer = thermometerRepository.findThermometerWithIdentifier(new ThermometerIdentifier(thermometerIdentifier));
        thermometer.updateTemperature(new TemperatureCelsius(temperature));
        thermometerRepository.save(thermometer);
    }
}
