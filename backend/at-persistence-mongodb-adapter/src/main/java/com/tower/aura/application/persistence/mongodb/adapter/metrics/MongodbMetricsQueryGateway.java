package com.tower.aura.application.persistence.mongodb.adapter.metrics;

import com.tower.aura.spi.persistence.metrics.MetricsQueryGateway;
import com.tower.aura.spi.persistence.metrics.model.*;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
class MongodbMetricsQueryGateway implements MetricsQueryGateway {
    @Override
    public List<PersistenceMetrics> findMetricsForPlace(PersistencePlaceIdentifier placeIdentifier) {
        return List.of(
                new PersistenceMetrics(
                        new PersistenceMetricsIdentifier(UUID.randomUUID().toString()),
                        new PersistenceMetricsName("Smart Light Bulb"),
                        new PersistenceDevice(
                                new PersistenceDeviceIdentifier(UUID.randomUUID().toString()),
                                new PersistenceDeviceType(new PersistenceDeviceTypeIdentifier(UUID.randomUUID().toString()), new PersistenceDeviceTypeName("Light Bulb")),
                                PersistenceDeviceData.fromMap(Map.of(
                                        new PersistenceMetricName("status"), PersistenceStringMetricValue.fromString("ON"),
                                        new PersistenceMetricName("color"), PersistenceStringMetricValue.fromString("#FFFF")
                                ))
                        )
                )
        );
    }
}
