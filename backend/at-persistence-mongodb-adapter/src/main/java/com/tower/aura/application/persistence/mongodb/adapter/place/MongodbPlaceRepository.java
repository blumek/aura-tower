package com.tower.aura.application.persistence.mongodb.adapter.place;

import java.util.List;

interface MongodbPlaceRepository {
    List<PlaceDocument> findUserPlaces(String userIdentifier);

    PlaceDocument save(PlaceDocument placeDocument);
}
