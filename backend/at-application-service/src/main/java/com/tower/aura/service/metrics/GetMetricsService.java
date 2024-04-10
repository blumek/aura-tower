package com.tower.aura.service.metrics;

import com.tower.aura.api.metrics.*;
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
                        UUID.randomUUID().toString(),
                        "Smart Light Bulb",
                        new ApiDeviceType(UUID.randomUUID().toString(), "Light Bulb"),
                        ApiDeviceData.of(Map.of(
                                "status", "ON",
                                "color", "#FFFF"
                        ))
                )
        ));
    }
}
