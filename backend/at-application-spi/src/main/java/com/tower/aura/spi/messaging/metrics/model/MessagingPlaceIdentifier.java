package com.tower.aura.spi.messaging.metrics.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record MessagingPlaceIdentifier(String value) {
    public MessagingPlaceIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Place identifier cannot be blank");
        }
    }
}
