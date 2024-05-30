package com.tower.aura.rest.web.adapter.controller.metric;

import com.tower.aura.api.metrics.GetMetricsReply;
import com.tower.aura.api.metrics.GetPlaceMetricsUseCase;
import com.tower.aura.api.metrics.GetPlaceMetricsRequest;
import com.tower.aura.api.place.model.ApiPlaceIdentifier;
import com.tower.aura.rest.web.adapter.controller.metric.model.RestWebMetricsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1")
class PlaceMetricsController {
    private final GetPlaceMetricsUseCase getPlaceMetricsUseCase;

    public PlaceMetricsController(GetPlaceMetricsUseCase getPlaceMetricsUseCase) {
        this.getPlaceMetricsUseCase = getPlaceMetricsUseCase;
    }

    @GetMapping("/places/{placeIdentifier}/metrics")
    public ResponseEntity<List<RestWebMetricsResponse>> retrieveMetricsForPlace(@PathVariable String placeIdentifier) {
        final var getMetricsReply = getPlaceMetricsUseCase.getPlaceMetrics(toGetPlaceMetricsRequest(placeIdentifier));
        return ok().body(toMetricsResponses(getMetricsReply));
    }

    private GetPlaceMetricsRequest toGetPlaceMetricsRequest(String placeIdentifier) {
        return new GetPlaceMetricsRequest(new ApiPlaceIdentifier(placeIdentifier));
    }

    private List<RestWebMetricsResponse> toMetricsResponses(GetMetricsReply getMetricsReply) {
        return getMetricsReply.metrics()
                .stream()
                .map(RestWebMetricsResponse::fromApiMetrics)
                .toList();
    }
}
