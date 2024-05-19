package com.tower.aura.service.place;

import com.tower.aura.api.place.GetUserPlacesReply;
import com.tower.aura.api.place.GetUserPlacesRequest;
import com.tower.aura.api.place.GetUserPlacesUseCase;
import com.tower.aura.api.place.model.ApiPlace;
import com.tower.aura.api.place.model.ApiPlaceIdentifier;
import com.tower.aura.api.place.model.ApiPlaceName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.tower.aura.api.place.model.ApiPlaceIcon.HOME;

@Service
public class GetUserPlacesService implements GetUserPlacesUseCase {
    @Override
    public GetUserPlacesReply getPlaces(GetUserPlacesRequest getUserPlacesRequest) {
        return new GetUserPlacesReply(List.of(
                new ApiPlace(new ApiPlaceIdentifier(UUID.randomUUID().toString()), new ApiPlaceName("Home"), HOME),
                new ApiPlace(new ApiPlaceIdentifier(UUID.randomUUID().toString()), new ApiPlaceName("Work"), HOME)
        ));
    }
}
