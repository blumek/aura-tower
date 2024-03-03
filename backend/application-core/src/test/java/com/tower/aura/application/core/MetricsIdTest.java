package com.tower.aura.application.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MetricsIdTest {
    @Test
    void twoIdenticalMetricsIdsAreEqual() {
        assertThat(givenMetricsId()).isEqualTo(givenMetricsId());
    }

    @Test
    void whenCreatingMetricsIdFromNullThenExceptionIsThrown() {
        assertThatThrownBy(() -> MetricsId.fromString(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenGettingValueAsStringThenExpectedValueIsReturned() {
        final var givenMetricsId = givenMetricsId();

        final var actualMetricsIdAsString = givenMetricsId.asString();

        assertThat(actualMetricsIdAsString).isEqualTo(actualMetricsIdAsString);
    }

    private static MetricsId givenMetricsId() {
        return MetricsId.fromString("givenValue");
    }
}