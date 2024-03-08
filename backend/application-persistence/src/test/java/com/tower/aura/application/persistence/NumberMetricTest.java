package com.tower.aura.application.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NumberMetricTest {
    public static Stream<Arguments> invalidArguments() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("givenName", null),
                Arguments.of(null, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidArguments")
    void whenCreatingNumberMetricFromNullThenExceptionIsThrown(String givenName, Number givenValue) {
        assertThatThrownBy(() -> NumberMetric.of(givenName, givenValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenGettingValueThenExpectedValueIsReturned() {
        final var givenNumberMetric = givenNumberMetric();

        final var actualValue = givenNumberMetric.value();

        assertThat(actualValue).isEqualTo(10);
    }

    private static NumberMetric givenNumberMetric() {
        return NumberMetric.of("givenName", 10);
    }
}