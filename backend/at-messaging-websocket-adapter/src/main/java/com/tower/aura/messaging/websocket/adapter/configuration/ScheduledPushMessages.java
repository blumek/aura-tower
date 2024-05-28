package com.tower.aura.messaging.websocket.adapter.configuration;

import com.tower.aura.spi.messaging.metrics.MetricsSendMessageGateway;
import com.tower.aura.spi.messaging.metrics.MetricsSendMessageRequest;
import com.tower.aura.spi.messaging.metrics.model.*;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class ScheduledPushMessages {
    private final MetricsSendMessageGateway metricsSendMessageGateway;

    public ScheduledPushMessages(MetricsSendMessageGateway metricsSendMessageGateway) {
        this.metricsSendMessageGateway = metricsSendMessageGateway;
    }

    @Scheduled(fixedRate = 800)
    public void sendMessage() {
        metricsSendMessageGateway.send(new MetricsSendMessageRequest(
                new MessagingMetrics(
                                new MessagingMetricsIdentifier("94ba6b51-4e5f-4984-afcc-2377c1961103"),
                                MessagingMetricsCollection.builder()
                                        .withMetric(new MessagingMetric(
                                                new MessagingMetricName("temperature"),
                                                new MessagingNumberMetricValue(RandomUtils.nextDouble(1, 39))
                                        ))
                                        .build()
                        )
                )
        );
    }

}