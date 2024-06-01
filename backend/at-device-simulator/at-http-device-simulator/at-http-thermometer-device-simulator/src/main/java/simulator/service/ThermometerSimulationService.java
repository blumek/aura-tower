package simulator.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
class ThermometerSimulationService {
    private final ThermometerService thermometerService;

    ThermometerSimulationService(ThermometerService thermometerService) {
        this.thermometerService = thermometerService;
    }

    @Scheduled(fixedDelay = 1300)
    void simulate() {
        thermometerService.updateTemperature("0c2ba6c3-5c96-4df3-b008-c68ca92137d3", Math.random() * 30);
    }
}
