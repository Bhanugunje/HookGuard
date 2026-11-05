package com.bhanu.hookguard.controller;

import com.bhanu.hookguard.entity.WebhookEvent;
import com.bhanu.hookguard.service.WebhookEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class WebhookEventController {

    private final WebhookEventService service;

    public WebhookEventController(WebhookEventService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WebhookEvent> createEvent(@RequestBody WebhookEvent event){
        WebhookEvent savedEvent = service.createEvent(event);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEvent);
    }

    @GetMapping
    public ResponseEntity<List<WebhookEvent>> getAllEvents(){
        return ResponseEntity.ok(service.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebhookEvent> getEventById(@PathVariable Long id){
        return service.getEventById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

