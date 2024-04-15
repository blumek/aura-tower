package com.tower.aura.api.authentication.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ApiReminderQuestionAnswer(String value) {
    public ApiReminderQuestionAnswer {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Answer cannot be blank");
        }
    }
}
