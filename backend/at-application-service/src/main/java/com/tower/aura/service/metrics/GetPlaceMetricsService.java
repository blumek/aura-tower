package com.tower.aura.service.metrics;

import com.tower.aura.api.metrics.GetMetricsReply;
import com.tower.aura.api.metrics.GetPlaceMetricsRequest;
import com.tower.aura.api.metrics.GetPlaceMetricsUseCase;
import com.tower.aura.api.metrics.model.ApiMetrics;
import com.tower.aura.api.place.model.ApiPlaceIdentifier;
import com.tower.aura.service.mappers.MetricsMapper;
import com.tower.aura.spi.persistence.metrics.MetricsQueryGateway;
import com.tower.aura.spi.persistence.metrics.model.PersistenceMetrics;
import com.tower.aura.spi.persistence.place.model.PersistencePlaceIdentifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class GetPlaceMetricsService implements GetPlaceMetricsUseCase {
    private final MetricsQueryGateway metricsQueryGateway;

    public GetPlaceMetricsService(MetricsQueryGateway metricsQueryGateway) {
        this.metricsQueryGateway = metricsQueryGateway;
    }

    @Override
    public GetMetricsReply getPlaceMetrics(GetPlaceMetricsRequest getPlaceMetricsRequest) {
        final var metricsForPlace = metricsQueryGateway.findMetricsForPlace(toPersistencePlaceIdentifier(getPlaceMetricsRequest.placeIdentifier()));
        return toGetMetricsReply(metricsForPlace);
    }

    private PersistencePlaceIdentifier toPersistencePlaceIdentifier(ApiPlaceIdentifier placeIdentifier) {
        return new PersistencePlaceIdentifier(placeIdentifier.value());
    }

    private GetMetricsReply toGetMetricsReply(List<PersistenceMetrics> metricsForPlace) {
        return new GetMetricsReply(toApiMetricsList(metricsForPlace));
    }

    private List<ApiMetrics> toApiMetricsList(List<PersistenceMetrics> metricsForPlace) {
        return metricsForPlace.stream()
                .map(MetricsMapper::toApiMetrics)
                .toList();
    }
}
