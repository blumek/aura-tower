package com.tower.aura.rest.web.adapter.controller.catalog;

import com.tower.aura.rest.web.adapter.controller.catalog.model.RestWebDeviceTypeCatalogResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/catalogs")
public class DeviceCatalogController {

    @GetMapping("/devices/types")
    public ResponseEntity<List<RestWebDeviceTypeCatalogResponse>> getReminderQuestions() {
        return ok().body(sampleResponse());
    }

    private List<RestWebDeviceTypeCatalogResponse> sampleResponse() {
        return List.of(
                new RestWebDeviceTypeCatalogResponse(UUID.randomUUID().toString(), "Bulb"),
                new RestWebDeviceTypeCatalogResponse(UUID.randomUUID().toString(), "Vacuum"),
                new RestWebDeviceTypeCatalogResponse(UUID.randomUUID().toString(), "Thermometer")
        );
    }
}
