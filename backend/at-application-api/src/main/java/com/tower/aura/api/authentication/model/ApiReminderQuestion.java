package com.tower.aura.api.authentication.model;

public record ApiReminderQuestion(ApiReminderQuestionIdentifier passwordIdentifier,
                                  ApiReminderQuestionAnswer questionAnswer) {
    public ApiReminderQuestion {
        if (passwordIdentifier == null) {
            throw new IllegalArgumentException("Password identifier cannot be null");
        }

        if (questionAnswer == null) {
            throw new IllegalArgumentException("Question answer cannot be null");
        }
    }
}
