package com.tower.aura.application.persistence.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


@ExtendWith(MockitoExtension.class)
class DefaultMongodbMetricsRepositoryTest {
    @Mock
    private SpringMongodbMetricsRepository springMongodbMetricsRepository;
    @InjectMocks
    private DefaultMongodbMetricsRepository defaultMongodbMetricsRepository;

    @Test
    void expectedMetricsDocumentIsReturnedWhenFindingById() {
        givenSpringMongodbMetricsRepositoryCanFindDocument();

        final var actualMetricsDocument = defaultMongodbMetricsRepository.findById("givenId");

        assertThat(actualMetricsDocument).contains(givenMetricsDocument());
    }

    private void givenSpringMongodbMetricsRepositoryCanFindDocument() {
        given(springMongodbMetricsRepository.findById(any())).willReturn(Optional.of(givenMetricsDocument()));
    }

    private static MetricsDocument givenMetricsDocument() {
        return MetricsDocument.empty("givenId");
    }

    @Test
    void theUnderlyingSpringMongodbMetricsRepositoryIsCalledWhenSaving() {
        givenSpringMongodbMetricsRepositoryCanSaveDocument();

        defaultMongodbMetricsRepository.save(givenMetricsDocument());

        then(springMongodbMetricsRepository).should().save(givenMetricsDocument());
    }

    @Test
    void expectedMetricsDocumentIsReturnedWhenSaving() {
        givenSpringMongodbMetricsRepositoryCanSaveDocument();

        final var actualMetricsDocument = defaultMongodbMetricsRepository.save(givenMetricsDocument());

        assertThat(actualMetricsDocument).isEqualTo(givenMetricsDocument());
    }

    private void givenSpringMongodbMetricsRepositoryCanSaveDocument() {
        given(springMongodbMetricsRepository.save(any())).willReturn(givenMetricsDocument());
    }
}