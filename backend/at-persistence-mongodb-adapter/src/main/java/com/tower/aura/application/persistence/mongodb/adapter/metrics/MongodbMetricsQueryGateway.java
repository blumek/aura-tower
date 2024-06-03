package com.tower.aura.application.persistence.mongodb.adapter.metrics;

import com.tower.aura.spi.persistence.metrics.MetricsQueryGateway;
import com.tower.aura.spi.persistence.metrics.model.*;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
class MongodbMetricsQueryGateway implements MetricsQueryGateway {
    @Override
    public List<PersistenceMetrics> findMetricsForPlace(PersistencePlaceIdentifier placeIdentifier) {
        return List.of(
                new PersistenceMetrics(
                        new PersistenceMetricsIdentifier("e37da368-180b-4287-916f-176f3bd35e12"),
                        new PersistenceMetricsName("Smart Light Bulb"),
                        new PersistenceDevice(
                                new PersistenceDeviceIdentifier("eb267f73-f474-43b0-9d0f-fdcfdcd877bb"),
                                new PersistenceDeviceType(new PersistenceDeviceTypeIdentifier("0554fdcf-2dea-471f-b753-19d890541050"), new PersistenceDeviceTypeName("Light Bulb")),
                                PersistenceDeviceData.fromMap(Map.of(
                                        new PersistenceMetricName("status"), PersistenceStringMetricValue.fromString("ON"),
                                        new PersistenceMetricName("color"), PersistenceStringMetricValue.fromString("#FFFF")
                                ))
                        )
                )
        );
    }
}
