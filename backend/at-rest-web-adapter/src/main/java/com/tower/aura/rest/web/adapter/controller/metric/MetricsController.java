package com.tower.aura.rest.web.adapter.controller.metric;

import com.tower.aura.api.metrics.GetMetricsUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/metrics")
public class MetricsController {
    private final GetMetricsUseCase getMetricsUseCase;

    public MetricsController(GetMetricsUseCase getMetricsUseCase) {
        this.getMetricsUseCase = getMetricsUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Metrics>> retrieveMetrics() {
        var metrics = List.of(
                new Metrics(
                        UUID.randomUUID().toString(),
                        "Smart Light Bulb",
                        new DeviceType(UUID.randomUUID().toString(), "Light Bulb"),
                        Map.of(
                                "status", "ON",
                                "color", "#FFFF"
                        )
                )
        );
        return ResponseEntity.ok().body(metrics);
    }
}
