package com.tower.aura.spi.persistence.place;

import com.tower.aura.spi.persistence.place.model.PersistencePlace;
import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;

import java.util.List;

public interface PlaceQueryGateway {
    List<PersistencePlace> findUserPlaces(PersistenceUserIdentifier userIdentifier);
}
