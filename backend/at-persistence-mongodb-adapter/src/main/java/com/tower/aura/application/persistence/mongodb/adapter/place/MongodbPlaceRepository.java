package com.tower.aura.application.persistence.mongodb.adapter.place;

import java.util.List;

interface MongodbPlaceRepository {
    List<PlaceDocument> findPlacesByIdentifiers(List<String> placeIdentifiers);

    PlaceDocument save(PlaceDocument placeDocument);

    void removeByIdentifier(String identifier);
}
