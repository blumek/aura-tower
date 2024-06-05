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
                        new PersistenceMetricsIdentifier("0c2ba6c3-5c96-4df3-b008-c68ca92137d3"),
                        new PersistenceMetricsName("Smart Light Bulb"),
                        new PersistenceDevice(
                                new PersistenceDeviceIdentifier("eb267f73-f474-43b0-9d0f-fdcfdcd877bb"),
                                new PersistenceDeviceType(new PersistenceDeviceTypeIdentifier("0554fdcf-2dea-471f-b753-19d890541050"), new PersistenceDeviceTypeName("Light Bulb")),
                                PersistenceDeviceData.fromMap(Map.of(
                                        new PersistenceMetricName("status"), PersistenceStringMetricValue.fromString("ON"),
                                        new PersistenceMetricName("color"), PersistenceStringMetricValue.fromString("#FFFF")
                                ))
                        )
                ),
                new PersistenceMetrics(
                        new PersistenceMetricsIdentifier("48dcf7a9-780b-4e96-8414-a236c776a92f"),
                        new PersistenceMetricsName("Thermometer"),
                        new PersistenceDevice(
                                new PersistenceDeviceIdentifier("eb267f73-f474-43b0-9d0f-fdcfdcd877bb"),
                                new PersistenceDeviceType(new PersistenceDeviceTypeIdentifier("0554fdcf-2dea-471f-b753-19d890541050"), new PersistenceDeviceTypeName("Thermometer")),
                                PersistenceDeviceData.fromMap(Map.of(
                                        new PersistenceMetricName("temperature"), PersistenceNumberMetricValue.fromNumber(10.0)
                                ))
                        )
                )
        );
    }
}
