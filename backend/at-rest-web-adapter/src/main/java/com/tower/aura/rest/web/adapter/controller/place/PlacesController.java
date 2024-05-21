package com.tower.aura.rest.web.adapter.controller.place;

import com.tower.aura.api.model.ApiUserIdentifier;
import com.tower.aura.api.place.*;
import com.tower.aura.api.place.model.ApiPlaceIcon;
import com.tower.aura.api.place.model.ApiPlaceIdentifier;
import com.tower.aura.api.place.model.ApiPlaceName;
import com.tower.aura.rest.web.adapter.controller.model.RestWebUserIdentifier;
import com.tower.aura.rest.web.adapter.controller.place.model.CreatePlaceRequest;
import com.tower.aura.rest.web.adapter.controller.place.model.RestWebPlaceIcon;
import com.tower.aura.rest.web.adapter.controller.place.model.RestWebPlaceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/places")
class PlacesController {
    private final GetUserPlacesUseCase getUserPlacesUseCase;
    private final CreatePlaceUseCase createPlaceUseCase;
    private final RemovePlaceUseCase removePlaceUseCase;

    public PlacesController(GetUserPlacesUseCase getUserPlacesUseCase,
                            CreatePlaceUseCase createPlaceUseCase,
                            RemovePlaceUseCase removePlaceUseCase) {
        this.getUserPlacesUseCase = getUserPlacesUseCase;
        this.createPlaceUseCase = createPlaceUseCase;
        this.removePlaceUseCase = removePlaceUseCase;
    }

    @GetMapping
    public ResponseEntity<List<RestWebPlaceResponse>> retrieveUserPlaces(
            @RequestHeader(name="Authorization") RestWebUserIdentifier userIdentifier) {
        final var getUserPlacesRequest = toGetUserPlacesRequest(userIdentifier);
        return ok().body(toMetricsResponses(getUserPlacesUseCase.getPlaces(getUserPlacesRequest)));
    }

    private static GetUserPlacesRequest toGetUserPlacesRequest(RestWebUserIdentifier userIdentifier) {
        return new GetUserPlacesRequest(new ApiUserIdentifier(userIdentifier.value()));
    }

    private List<RestWebPlaceResponse> toMetricsResponses(GetUserPlacesReply getUserPlacesReply) {
        return getUserPlacesReply.places()
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

    @DeleteMapping("/{placeIdentifier}")
    public ResponseEntity<?> removePlace(@PathVariable String placeIdentifier) {
        removePlaceUseCase.remove(toRemovePlaceRequest(placeIdentifier));
        return noContent().build();
    }

    private RemovePlaceRequest toRemovePlaceRequest(String placeIdentifier) {
        return new RemovePlaceRequest(
                new ApiPlaceIdentifier(placeIdentifier)
        );
    }
}
