package com.tower.aura.rest.web.adapter.controller.catalog;

import com.tower.aura.rest.web.adapter.controller.catalog.model.RestWebReminderQuestionsCatalogResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/catalog")
public class AuthenticationCatalogController {

    @GetMapping("/reminder-questions")
    public ResponseEntity<List<RestWebReminderQuestionsCatalogResponse>> getReminderQuestions() {
        return ok().body(sampleResponse());
    }

    private List<RestWebReminderQuestionsCatalogResponse> sampleResponse() {
        return List.of(
                new RestWebReminderQuestionsCatalogResponse(UUID.randomUUID().toString(), "What is your dog's name?"),
                new RestWebReminderQuestionsCatalogResponse(UUID.randomUUID().toString(), "What is your childhood nickname?"),
                new RestWebReminderQuestionsCatalogResponse(UUID.randomUUID().toString(), "What is the name of your primary school?"),
                new RestWebReminderQuestionsCatalogResponse(UUID.randomUUID().toString(), "What is your mother's maiden name?")
        );
    }
}
