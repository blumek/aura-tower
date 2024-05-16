package com.tower.aura.rest.web.adapter.controller.place;

import com.tower.aura.api.place.CreatePlaceReply;
import com.tower.aura.api.place.CreatePlaceUseCase;
import com.tower.aura.api.place.GetPlacesReply;
import com.tower.aura.api.place.GetPlacesUseCase;
import com.tower.aura.api.place.model.ApiPlaceIcon;
import com.tower.aura.api.place.model.ApiPlaceName;
import com.tower.aura.rest.web.adapter.controller.place.model.CreatePlaceRequest;
import com.tower.aura.rest.web.adapter.controller.place.model.RestWebPlaceIcon;
import com.tower.aura.rest.web.adapter.controller.place.model.RestWebPlaceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/places")
class PlacesController {
    private final GetPlacesUseCase getPlacesUseCase;
    private final CreatePlaceUseCase createPlaceUseCase;

    public PlacesController(GetPlacesUseCase getPlacesUseCase,
                            CreatePlaceUseCase createPlaceUseCase) {
        this.getPlacesUseCase = getPlacesUseCase;
        this.createPlaceUseCase = createPlaceUseCase;
    }

    @GetMapping
    public ResponseEntity<List<RestWebPlaceResponse>> retrievePlaces() {
        return ok().body(toMetricsResponses(getPlacesUseCase.getPlaces()));
    }

    private List<RestWebPlaceResponse> toMetricsResponses(GetPlacesReply getPlacesReply) {
        return getPlacesReply.places()
                .stream()
                .map(RestWebPlaceResponse::fromApiPlace)
                .toList();
    }

    @PostMapping
    public ResponseEntity<RestWebPlaceResponse> createPlace(@RequestBody CreatePlaceRequest createPlaceRequest) {
        final var createPlaceReply = createPlaceUseCase.create(toCreatePlaceUseCaseRequest(createPlaceRequest));
        return ok(toRestWebPlaceResponse(createPlaceReply));
    }

    private com.tower.aura.api.place.CreatePlaceRequest toCreatePlaceUseCaseRequest(CreatePlaceRequest createPlaceRequest) {
        return new com.tower.aura.api.place.CreatePlaceRequest(
                new ApiPlaceName(createPlaceRequest.name()),
                ApiPlaceIcon.valueOf(createPlaceRequest.icon().name())
        );
    }

    private RestWebPlaceResponse toRestWebPlaceResponse(CreatePlaceReply createPlaceReply) {
        return new RestWebPlaceResponse(
                createPlaceReply.place().identifier().value(),
                createPlaceReply.place().name().value(),
                RestWebPlaceIcon.fromApiPlaceIcon(createPlaceReply.place().icon())
        );
    }
}
