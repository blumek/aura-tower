package com.tower.aura.application.core;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MetricsTest {
    public static Stream<Arguments> invalidArguments() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(givenMetricsId(), null),
                Arguments.of(null, givenMetricsCollection())
        );
    }

    private static MetricsId givenMetricsId() {
        return MetricsId.fromString("givenValue");
    }

    private static MetricsCollection givenMetricsCollection() {
        return MetricsCollection.builder().build();
    }

    @ParameterizedTest
    @MethodSource("invalidArguments")
    void whenCreatingMetricsFromNullThenExceptionIsThrown(MetricsId givenMetricId, MetricsCollection givenMetricsCollection) {
        assertThatThrownBy(() -> Metrics.from(givenMetricId, givenMetricsCollection))
                .isInstanceOf(IllegalArgumentException.class);
    }
}