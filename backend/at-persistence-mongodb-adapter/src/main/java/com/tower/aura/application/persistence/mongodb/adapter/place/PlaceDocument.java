package com.tower.aura.application.persistence.mongodb.adapter.place;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class PlaceDocument {
    @Id
    private String identifier;
    private String name;
    private MongodbPlaceIcon icon;

    private PlaceDocument() {}

    public PlaceDocument(String identifier, String name, MongodbPlaceIcon icon) {
        this.identifier = identifier;
        this.name = name;
        this.icon = icon;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public MongodbPlaceIcon getIcon() {
        return icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaceDocument that)) return false;
        return Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identifier);
    }

    @Override
    public String toString() {
        return "PlaceDocument{" +
                "identifier='" + identifier + '\'' +
                ", name='" + name + '\'' +
                ", icon=" + icon +
                '}';
    }
}
