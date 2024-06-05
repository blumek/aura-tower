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
        thermometerService.updateTemperature("48dcf7a9-780b-4e96-8414-a236c776a92f", Math.random() * 30);
    }
}
