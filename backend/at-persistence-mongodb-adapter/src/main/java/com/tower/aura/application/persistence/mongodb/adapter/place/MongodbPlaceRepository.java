package com.tower.aura.application.persistence.mongodb.adapter.place;

interface MongodbPlaceRepository {
    PlaceDocument save(PlaceDocument placeDocument);
}
