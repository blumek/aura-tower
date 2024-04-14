package com.tower.aura.api.auth;

import com.tower.aura.api.auth.model.ApiForgotPassword;
import com.tower.aura.api.auth.model.ApiUserIdentifier;

public record ChangeReminderQuestionRequest(ApiUserIdentifier userIdentifier,
                                            ApiForgotPassword forgotPassword) {
    public ChangeReminderQuestionRequest {
        if (userIdentifier == null) {
            throw new IllegalArgumentException("User identifier cannot be null");
        }

        if (forgotPassword == null) {
            throw new IllegalArgumentException("Forgot password cannot be null");
        }
    }
}
