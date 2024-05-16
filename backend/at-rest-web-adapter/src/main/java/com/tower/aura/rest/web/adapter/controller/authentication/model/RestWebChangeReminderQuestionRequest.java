package com.tower.aura.rest.web.adapter.controller.authentication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tower.aura.api.authentication.ChangeReminderQuestionRequest;
import com.tower.aura.api.authentication.model.ApiReminderQuestion;
import com.tower.aura.api.authentication.model.ApiReminderQuestionAnswer;
import com.tower.aura.api.authentication.model.ApiReminderQuestionIdentifier;
import com.tower.aura.api.authentication.model.ApiUserIdentifier;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebChangeReminderQuestionRequest(
        @JsonProperty("reminderQuestionId") String reminderQuestionIdentifier,
        @JsonProperty("reminderQuestionAnswer") String reminderQuestionAnswer) {
    public RestWebChangeReminderQuestionRequest {
        if (isBlank(reminderQuestionIdentifier)) {
            throw new IllegalArgumentException("Reminder question identifier cannot be blank");
        }

        if (isBlank(reminderQuestionAnswer)) {
            throw new IllegalArgumentException("Reminder question answer cannot be blank");
        }
    }

    public ChangeReminderQuestionRequest toChangeReminderQuestionRequestWithUserIdentifier(String userIdentifier) {
        return new ChangeReminderQuestionRequest(
                new ApiUserIdentifier(userIdentifier),
                new ApiReminderQuestion(
                        new ApiReminderQuestionIdentifier(reminderQuestionIdentifier),
                        new ApiReminderQuestionAnswer(reminderQuestionAnswer)
                )
        );
    }
}
