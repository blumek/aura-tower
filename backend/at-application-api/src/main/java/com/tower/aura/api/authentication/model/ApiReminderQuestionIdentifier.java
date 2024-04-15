package com.tower.aura.api.authentication.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiReminderQuestionIdentifier(String value) {
    public ApiReminderQuestionIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }
    }
}
