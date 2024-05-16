package com.tower.aura.rest.web.adapter.controller.place;

import com.tower.aura.api.place.GetPlacesReply;
import com.tower.aura.api.place.GetPlacesUseCase;
import com.tower.aura.rest.web.adapter.controller.place.model.RestWebPlacesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/places")
class PlacesController {
    private final GetPlacesUseCase getPlacesUseCase;

    public PlacesController(GetPlacesUseCase getPlacesUseCase) {
        this.getPlacesUseCase = getPlacesUseCase;
    }

    @GetMapping
    public ResponseEntity<List<RestWebPlacesResponse>> retrievePlaces() {
        return ok().body(toMetricsResponses(getPlacesUseCase.getPlaces()));
    }

    private List<RestWebPlacesResponse> toMetricsResponses(GetPlacesReply getPlacesReply) {
        return getPlacesReply.places()
                .stream()
                .map(RestWebPlacesResponse::fromApiPlace)
                .toList();
    }
}
