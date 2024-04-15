package com.tower.aura.api.authentication;

import com.tower.aura.api.authentication.model.ApiReminderQuestion;
import com.tower.aura.api.authentication.model.ApiPassword;
import com.tower.aura.api.authentication.model.ApiUsername;

public record RegisterUserRequest(ApiUsername username,
                                  ApiPassword password,
                                  ApiReminderQuestion reminderQuestion) {
    public RegisterUserRequest {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (reminderQuestion == null) {
            throw new IllegalArgumentException("Reminder question cannot be null");
        }
    }
}
