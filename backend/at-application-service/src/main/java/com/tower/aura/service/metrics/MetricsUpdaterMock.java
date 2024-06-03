package com.tower.aura.service.metrics;

import com.tower.aura.spi.messaging.metrics.MetricsSendMessageGateway;
import com.tower.aura.spi.messaging.metrics.MetricsSendMessageRequest;
import com.tower.aura.spi.messaging.metrics.model.*;
import com.tower.aura.spi.persistence.place.PlaceQueryGateway;
import com.tower.aura.spi.persistence.place.model.PersistencePlace;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

import static java.util.Locale.ROOT;

@Service
public class MetricsUpdaterMock {
    private final PlaceQueryGateway placeQueryGateway;
    private final MetricsSendMessageGateway metricsSendMessageGateway;

    public MetricsUpdaterMock(PlaceQueryGateway placeQueryGateway,
                              MetricsSendMessageGateway metricsSendMessageGateway) {
        this.placeQueryGateway = placeQueryGateway;
        this.metricsSendMessageGateway = metricsSendMessageGateway;
    }

    @Scheduled(fixedDelay = 1500)
    public void updateMetrics() {
        placeQueryGateway.findAllPlaces().stream()
                .map(PersistencePlace::placeIdentifier)
                .forEach(this::sendMetrics);
    }

    private void sendMetrics(PersistencePlaceIdentifier placeIdentifier) {
        metricsSendMessageGateway.send(new MetricsSendMessageRequest(
                new MessagingPlaceIdentifier(placeIdentifier.value()),
                new MessagingMetrics(
                        new MessagingMetricsIdentifier("e37da368-180b-4287-916f-176f3bd35e12"),
                        MessagingDeviceData.builder()
                                .withMetric(new MessagingMetric(new MessagingMetricName("status"), new MessagingStringMetricValue("ON")))
                                .withMetric(new MessagingMetric(new MessagingMetricName("color"), new MessagingStringMetricValue(randomHexColor())))
                                .build()
                )
        ));
    }

    private static String randomHexColor() {
        final var randomInteger = new Random().nextInt(0xffffff + 1);
        return String.format("#%06x", randomInteger).toUpperCase(ROOT);
    }
}
