package persistence;

import com.tower.aura.spi.persistence.StringMetric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringMetricTest {
    public static Stream<Arguments> invalidArguments() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("givenName", null),
                Arguments.of(null, "givenValue")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidArguments")
    void whenCreatingStringMetricFromNullThenExceptionIsThrown(String givenName, String givenValue) {
        assertThatThrownBy(() -> StringMetric.of(givenName, givenValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenGettingValueThenExpectedValueIsReturned() {
        final var givenStringMetric = givenStringMetric();

        final var actualValue = givenStringMetric.value();

        assertThat(actualValue).isEqualTo("givenValue");
    }

    private static StringMetric givenStringMetric() {
        return StringMetric.of("givenName", "givenValue");
    }
}