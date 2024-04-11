package com.tower.aura.service.metrics;

import com.tower.aura.api.metrics.*;
import com.tower.aura.api.metrics.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class GetMetricsService implements GetMetricsUseCase {
    @Override
    public GetMetricsReply getMetrics() {
        return new GetMetricsReply(List.of(
                new ApiMetrics(
                        new ApiMetricsIdentifier(UUID.randomUUID().toString()),
                        new ApiMetricsName("Smart Light Bulb"),
                        new ApiDeviceType(new ApiDeviceTypeIdentifier(UUID.randomUUID().toString()), new ApiDeviceTypeName("Light Bulb")),
                        ApiDeviceData.of(Map.of(
                                "status", "ON",
                                "color", "#FFFF"
                        ))
                )
        ));
    }
}
