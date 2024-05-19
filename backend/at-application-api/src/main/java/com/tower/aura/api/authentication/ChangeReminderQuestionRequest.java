package com.tower.aura.api.authentication;

import com.tower.aura.api.authentication.model.ApiReminderQuestion;
import com.tower.aura.api.model.ApiUserIdentifier;

public record ChangeReminderQuestionRequest(ApiUserIdentifier userIdentifier,
                                            ApiReminderQuestion forgotPassword) {
    public ChangeReminderQuestionRequest {
        if (userIdentifier == null) {
            throw new IllegalArgumentException("User identifier cannot be null");
        }

        if (forgotPassword == null) {
            throw new IllegalArgumentException("Forgot password cannot be null");
        }
    }
}
