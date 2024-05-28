package com.tower.aura.messaging.websocket.adapter.metrics;

import com.tower.aura.spi.messaging.metrics.MetricsSendMessageGateway;
import com.tower.aura.spi.messaging.metrics.MetricsSendMessageRequest;
import com.tower.aura.spi.messaging.metrics.model.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
class WebSocketMetricsSendMessageGateway implements MetricsSendMessageGateway {
    private final SimpMessagingTemplate messagingTemplate;

    WebSocketMetricsSendMessageGateway(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void send(MetricsSendMessageRequest metricsSendMessageRequest) {
        messagingTemplate.convertAndSend("/topic/places/%s/metrics".formatted(metricsSendMessageRequest.metrics().metricsId().value()), toWebSocketMetrics(metricsSendMessageRequest));
    }

    private WebSocketMetrics toWebSocketMetrics(MetricsSendMessageRequest metricsSendMessageRequest) {
        return new WebSocketMetrics(
                metricsSendMessageRequest.metrics().metricsId().value(),
                toMetricsCollectionMap(metricsSendMessageRequest)
        );
    }

    private static Map<String, Object> toMetricsCollectionMap(MetricsSendMessageRequest metricsSendMessageRequest) {
        return metricsSendMessageRequest.metrics()
                .metricsCollection()
                .asStream()
                .collect(toMap(metric -> metric.metricName().value(), metric -> toValue(metric.metricValue())));
    }

    private static Object toValue(MessagingMetricValue metricValue) {
        return switch (metricValue) {
            case MessagingBooleanMetricValue booleanMetricValue -> booleanMetricValue.asBoolean();
            case MessagingNumberMetricValue numberMetricValue -> numberMetricValue.asNumber();
            case MessagingStringMetricValue messagingStringMetricValue -> messagingStringMetricValue.asString();
        };
    }
}
