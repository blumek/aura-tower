package com.tower.aura.service.place;

import com.tower.aura.api.place.CreatePlaceReply;
import com.tower.aura.api.place.CreatePlaceRequest;
import com.tower.aura.api.place.CreatePlaceUseCase;
import com.tower.aura.api.place.model.ApiPlace;
import com.tower.aura.api.place.model.ApiPlaceIcon;
import com.tower.aura.api.place.model.ApiPlaceIdentifier;
import com.tower.aura.api.place.model.ApiPlaceName;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreatePlaceService implements CreatePlaceUseCase {
    @Override
    public CreatePlaceReply create(CreatePlaceRequest createPlaceRequest) {
        return new CreatePlaceReply(new ApiPlace(
                new ApiPlaceIdentifier(UUID.randomUUID().toString()),
                new ApiPlaceName(createPlaceRequest.name().value()),
                ApiPlaceIcon.valueOf(createPlaceRequest.icon().name())
        ));
    }
}
