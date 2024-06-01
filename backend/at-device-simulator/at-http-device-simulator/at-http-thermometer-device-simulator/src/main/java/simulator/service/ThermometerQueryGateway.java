package simulator.service;

import org.springframework.stereotype.Service;
import simulator.model.ThermometerIdentifier;
import simulator.model.ThermometerRepository;
import simulator.model.ThermometerSnapshot;

@Service
public class ThermometerQueryGateway {
    private final ThermometerRepository thermometerRepository;

    public ThermometerQueryGateway(ThermometerRepository thermometerRepository) {
        this.thermometerRepository = thermometerRepository;
    }

    public ThermometerSnapshot findThermometerWithIdentifier(String thermometerIdentifier) {
        return thermometerRepository
                .findThermometerWithIdentifier(new ThermometerIdentifier(thermometerIdentifier))
                .toThermometerSnapshot();
    }
}
