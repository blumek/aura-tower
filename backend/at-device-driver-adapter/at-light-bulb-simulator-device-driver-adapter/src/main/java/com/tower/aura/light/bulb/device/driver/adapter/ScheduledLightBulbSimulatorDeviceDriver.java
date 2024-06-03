package com.tower.aura.light.bulb.device.driver.adapter;

import com.tower.aura.spi.device.DeviceDriverProcessor;
import com.tower.aura.spi.messaging.metrics.MetricsSendMessageGateway;
import com.tower.aura.spi.messaging.metrics.MetricsSendMessageRequest;
import com.tower.aura.spi.messaging.metrics.model.*;
import com.tower.aura.spi.persistence.place.PlaceQueryGateway;
import com.tower.aura.spi.persistence.place.model.PersistencePlace;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

//TODO Fix the class, current state just for POC
@Service
class ScheduledLightBulbSimulatorDeviceDriver implements DeviceDriverProcessor {
    private final RestClient restClient;
    private final PlaceQueryGateway placeQueryGateway;
    private final MetricsSendMessageGateway metricsSendMessageGateway;

    ScheduledLightBulbSimulatorDeviceDriver(RestClient restClient, PlaceQueryGateway placeQueryGateway,
                                            MetricsSendMessageGateway metricsSendMessageGateway) {
        this.restClient = restClient;
        this.placeQueryGateway = placeQueryGateway;
        this.metricsSendMessageGateway = metricsSendMessageGateway;
    }

    @Override
    public void process() {
        final var lightBulb = restClient.get()
                .uri("http://localhost:8081/v1/light-bulbs/0c2ba6c3-5c96-4df3-b008-c68ca92137d3")
                .retrieve()
                .body(LightBulb.class);

        placeQueryGateway.findAllPlaces().stream()
                .map(PersistencePlace::placeIdentifier)
                .forEach(placeIdentifier -> sendMetrics(placeIdentifier, lightBulb));
    }

    private void sendMetrics(PersistencePlaceIdentifier placeIdentifier, LightBulb lightBulb) {
        metricsSendMessageGateway.send(new MetricsSendMessageRequest(
                new MessagingPlaceIdentifier(placeIdentifier.value()),
                new MessagingMetrics(
                        new MessagingMetricsIdentifier(lightBulb.identifier()),
                        MessagingDeviceData.builder()
                                .withMetric(new MessagingMetric(new MessagingMetricName("status"), new MessagingStringMetricValue(lightBulb.isOn() ? "ON" : "OFF")))
                                .withMetric(new MessagingMetric(new MessagingMetricName("color"), new MessagingStringMetricValue(lightBulb.hexColor())))
                                .build()
                )
        ));
    }
}
