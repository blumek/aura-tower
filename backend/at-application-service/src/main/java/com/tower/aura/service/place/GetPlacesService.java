package com.tower.aura.service.place;

import com.tower.aura.api.place.GetPlacesReply;
import com.tower.aura.api.place.GetPlacesUseCase;
import com.tower.aura.api.place.model.ApiPlace;
import com.tower.aura.api.place.model.ApiPlaceIdentifier;
import com.tower.aura.api.place.model.ApiPlaceName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.tower.aura.api.place.model.ApiPlaceIcon.HOME;

@Service
public class GetPlacesService implements GetPlacesUseCase {
    @Override
    public GetPlacesReply getPlaces() {
        return new GetPlacesReply(List.of(
                new ApiPlace(new ApiPlaceIdentifier(UUID.randomUUID().toString()), new ApiPlaceName("Home"), HOME),
                new ApiPlace(new ApiPlaceIdentifier(UUID.randomUUID().toString()), new ApiPlaceName("Work"), HOME)
        ));
    }
}
