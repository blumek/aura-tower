package com.tower.aura.spi.persistence.place;

public interface PlacePersistenceGateway {
    PlacePersistenceReply persist(PlacePersistenceRequest placePersistenceRequest);
}
