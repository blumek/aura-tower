package com.tower.aura.rest.web.adapter.controller.error.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public record RestWebErrorResponse(@JsonProperty("timestamp") ZonedDateTime timestamp,
                                   @JsonProperty("path") String path,
                                   @JsonProperty("message") String message) {
}
