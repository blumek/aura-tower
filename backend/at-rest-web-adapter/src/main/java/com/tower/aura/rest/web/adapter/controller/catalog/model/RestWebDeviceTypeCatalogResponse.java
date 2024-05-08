package com.tower.aura.rest.web.adapter.controller.catalog.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebDeviceTypeCatalogResponse(@JsonProperty("deviceTypeIdentifier") String deviceTypeIdentifier,
                                               @JsonProperty("deviceTypeName") String deviceTypeName) {
    public RestWebDeviceTypeCatalogResponse {
        if (isBlank(deviceTypeIdentifier)) {
            throw new IllegalArgumentException("Device type identifier cannot be blank");
        }

        if (isBlank(deviceTypeName)) {
            throw new IllegalArgumentException("Device type name cannot be blank");
        }
    }
}
