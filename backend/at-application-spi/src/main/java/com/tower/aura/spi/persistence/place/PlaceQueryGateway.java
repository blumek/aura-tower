package com.tower.aura.spi.persistence.place;

import com.tower.aura.spi.persistence.place.model.PersistencePlace;

import java.util.List;

public interface PlaceQueryGateway {
    List<PersistencePlace> findUserPlaces(String userIdentifier);
}
