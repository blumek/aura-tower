package com.tower.aura.rest.web.adapter.controller.authentication.model;

import com.tower.aura.api.authentication.RegisterUserRequest;
import com.tower.aura.api.authentication.model.*;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebRegisterRequest(String username,
                                     String password,
                                     String reminderQuestionIdentifier,
                                     String reminderQuestionAnswer) {
    public RestWebRegisterRequest {
        if (isBlank(username)) {
            throw new IllegalArgumentException("Username cannot be blank");
        }

        if (isBlank(password)) {
            throw new IllegalArgumentException("Password cannot be blank");
        }

        if (isBlank(reminderQuestionIdentifier)) {
            throw new IllegalArgumentException("Reminder question identifier cannot be blank");
        }

        if (isBlank(reminderQuestionAnswer)) {
            throw new IllegalArgumentException("Reminder question answer cannot be blank");
        }
    }

    public RegisterUserRequest toRegisterUserRequest() {
        return new RegisterUserRequest(
                new ApiUsername(username),
                new ApiPassword(password),
                new ApiReminderQuestion(
                        new ApiReminderQuestionIdentifier(reminderQuestionIdentifier),
                        new ApiReminderQuestionAnswer(reminderQuestionAnswer)
                )
        );
    }
}
