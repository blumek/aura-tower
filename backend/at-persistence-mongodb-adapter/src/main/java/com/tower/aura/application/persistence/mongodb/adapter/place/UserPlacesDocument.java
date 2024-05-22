package com.tower.aura.application.persistence.mongodb.adapter.place;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class UserPlacesDocument {
    @Id
    private String userIdentifier;
    private List<String> placeIdentifiers;

    private UserPlacesDocument() {}

    public UserPlacesDocument(String userIdentifier, List<String> placeIdentifiers) {
        this.userIdentifier = userIdentifier;
        this.placeIdentifiers = placeIdentifiers;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public List<String> getPlaceIdentifiers() {
        return placeIdentifiers;
    }

    public UserPlacesDocument addPlaceIdentifier(String placeIdentifier) {
        placeIdentifiers.add(placeIdentifier);
        return this;
    }

    public UserPlacesDocument removePlaceIdentifier(String placeIdentifier) {
        placeIdentifiers.remove(placeIdentifier);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPlacesDocument that)) return false;
        return Objects.equals(userIdentifier, that.userIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userIdentifier);
    }

    @Override
    public String toString() {
        return "UserPlacesDocument{" +
                "userIdentifier='" + userIdentifier + '\'' +
                ", placeIdentifiers=" + placeIdentifiers +
                '}';
    }
}
