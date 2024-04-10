package com.tower.aura.rest.web.adapter.controller.metric;

import com.tower.aura.api.metrics.GetMetricsReply;
import com.tower.aura.api.metrics.GetMetricsUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metrics")
class MetricsController {
    private final GetMetricsUseCase getMetricsUseCase;

    public MetricsController(GetMetricsUseCase getMetricsUseCase) {
        this.getMetricsUseCase = getMetricsUseCase;
    }

    @GetMapping
    public ResponseEntity<List<MetricsResponse>> retrieveMetrics() {
        final var metrics = toMetricsResponses(getMetricsUseCase.getMetrics());
        return ResponseEntity.ok().body(metrics);
    }

    private List<MetricsResponse> toMetricsResponses(GetMetricsReply getMetricsReply) {
        return getMetricsReply.metrics().stream()
                .map(MetricsResponse::fromApiMetrics)
                .toList();
    }
}
