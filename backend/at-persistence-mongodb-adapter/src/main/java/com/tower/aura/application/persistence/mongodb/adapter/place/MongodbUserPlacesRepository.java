package com.tower.aura.application.persistence.mongodb.adapter.place;

import java.util.List;

public interface MongodbUserPlacesRepository {
    List<String> findUserPlaceIdentifiers(String userIdentifier);

    void addUserPlace(String userIdentifier, String placeIdentifier);
}
