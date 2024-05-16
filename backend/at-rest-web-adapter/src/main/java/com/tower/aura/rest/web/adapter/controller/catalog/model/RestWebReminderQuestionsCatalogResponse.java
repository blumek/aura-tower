package com.tower.aura.rest.web.adapter.controller.catalog.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebReminderQuestionsCatalogResponse(@JsonProperty("id") String reminderQuestionIdentifier,
                                                      @JsonProperty("question") String reminderQuestion) {
    public RestWebReminderQuestionsCatalogResponse {
        if (isBlank(reminderQuestionIdentifier)) {
            throw new IllegalArgumentException("Reminder question identifier cannot be blank");
        }

        if (isBlank(reminderQuestion)) {
            throw new IllegalArgumentException("Reminder question cannot be blank");
        }
    }
}
