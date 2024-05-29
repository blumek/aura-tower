package com.tower.aura.rest.web.adapter.controller.metric;

import com.tower.aura.api.metrics.GetMetricsReply;
import com.tower.aura.api.metrics.GetMetricsUseCase;
import com.tower.aura.rest.web.adapter.controller.metric.model.RestWebMetricsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1")
class MetricsControllerV2 {
    private final GetMetricsUseCase getMetricsUseCase;

    public MetricsControllerV2(GetMetricsUseCase getMetricsUseCase) {
        this.getMetricsUseCase = getMetricsUseCase;
    }

    @GetMapping("/places/{placeIdentifier}/metrics")
    public ResponseEntity<List<RestWebMetricsResponse>> retrieveMetricsForPlace(@PathVariable String placeIdentifier) {
        return ok().body(toMetricsResponses(getMetricsUseCase.getMetrics()));
    }

    private List<RestWebMetricsResponse> toMetricsResponses(GetMetricsReply getMetricsReply) {
        return getMetricsReply.metrics()
                .stream()
                .map(RestWebMetricsResponse::fromApiMetrics)
                .toList();
    }
}
