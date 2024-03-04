package com.tower.aura.application.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MetricsCollectionTest {
    @Test
    void twoIdenticalMetricsCollectionsAreBeEqual() {
        assertThat(givenMetricsCollection()).isEqualTo(givenMetricsCollection());
    }

    @Test
    void addingTwoMetricsWithTheSameNameResultsOnlyInLastOneAdded() {
        final var givenMetricsCollection = MetricsCollection.builder()
                .withMetric(givenMetricWithAlreadyExistingName())
                .withMetric(givenMetric())
                .build();

        assertThat(givenMetricsCollection).isEqualTo(givenMetricsCollection());
    }

    private static StringMetric givenMetricWithAlreadyExistingName() {
        return StringMetric.of("givenMetricName", "givenAnotherMetricValue");
    }

    private static StringMetric givenMetric() {
        return StringMetric.of("givenMetricName", "givenMetricValue");
    }

    private static MetricsCollection givenMetricsCollection() {
        return MetricsCollection.builder()
                .withMetric(givenMetric())
                .build();
    }

    @Test
    void whenGettingAsCollectionThenExpectedCollectionShouldBeReturned() {
        final var givenMetricsCollection = givenMetricsCollection();

        final var actualCollection = givenMetricsCollection.asCollection();

        assertThat(actualCollection).containsExactly(givenMetric());
    }

    @Test
    void whenGettingAsStreamThenExpectedCollectionShouldBeReturned() {
        final var givenMetricsCollection = givenMetricsCollection();

        final var actualStream = givenMetricsCollection.asStream();

        assertThat(actualStream).containsExactly(givenMetric());
    }
}