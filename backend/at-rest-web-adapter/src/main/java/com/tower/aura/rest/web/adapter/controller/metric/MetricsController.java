package com.tower.aura.rest.web.adapter.controller.metric;

import com.tower.aura.api.metrics.GetMetricsReply;
import com.tower.aura.api.metrics.GetMetricsUseCase;
import com.tower.aura.rest.web.adapter.controller.metric.model.RestWebMetricsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/metrics")
class MetricsController {
    private final GetMetricsUseCase getMetricsUseCase;

    public MetricsController(GetMetricsUseCase getMetricsUseCase) {
        this.getMetricsUseCase = getMetricsUseCase;
    }

    @GetMapping
    public ResponseEntity<List<RestWebMetricsResponse>> retrieveMetrics() {
        return ok().body(toMetricsResponses(getMetricsUseCase.getMetrics()));
    }

    private List<RestWebMetricsResponse> toMetricsResponses(GetMetricsReply getMetricsReply) {
        return getMetricsReply.metrics()
                .stream()
                .map(RestWebMetricsResponse::fromApiMetrics)
                .toList();
    }
}
