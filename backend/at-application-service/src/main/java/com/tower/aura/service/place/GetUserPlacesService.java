package com.tower.aura.service.place;

import com.tower.aura.api.place.GetUserPlacesReply;
import com.tower.aura.api.place.GetUserPlacesRequest;
import com.tower.aura.api.place.GetUserPlacesUseCase;
import com.tower.aura.api.place.model.ApiPlace;
import com.tower.aura.api.place.model.ApiPlaceIcon;
import com.tower.aura.api.place.model.ApiPlaceIdentifier;
import com.tower.aura.api.place.model.ApiPlaceName;
import com.tower.aura.spi.persistence.place.PlaceQueryGateway;
import com.tower.aura.spi.persistence.place.model.PersistencePlace;
import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserPlacesService implements GetUserPlacesUseCase {
    private final PlaceQueryGateway placeQueryGateway;

    public GetUserPlacesService(PlaceQueryGateway placeQueryGateway) {
        this.placeQueryGateway = placeQueryGateway;
    }

    @Override
    public GetUserPlacesReply getPlaces(GetUserPlacesRequest getUserPlacesRequest) {
        return toGetUserPlacesReply(placeQueryGateway.findUserPlaces(toPersistenceUserIdentifier(getUserPlacesRequest)));
    }

    private static PersistenceUserIdentifier toPersistenceUserIdentifier(GetUserPlacesRequest getUserPlacesRequest) {
        return new PersistenceUserIdentifier(getUserPlacesRequest.userIdentifier().value());
    }

    private GetUserPlacesReply toGetUserPlacesReply(List<PersistencePlace> userPlaces) {
        return new GetUserPlacesReply(toApiPlaces(userPlaces));
    }

    private static List<ApiPlace> toApiPlaces(List<PersistencePlace> userPlaces) {
        return userPlaces
                .stream()
                .map(GetUserPlacesService::toApiPlace)
                .toList();
    }

    private static ApiPlace toApiPlace(PersistencePlace persistencePlace) {
        return new ApiPlace(
                new ApiPlaceIdentifier(persistencePlace.placeIdentifier().value()),
                new ApiPlaceName(persistencePlace.placeName().value()),
                ApiPlaceIcon.valueOf(persistencePlace.placeIcon().name())
        );
    }
}
