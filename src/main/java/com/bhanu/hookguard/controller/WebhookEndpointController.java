package com.bhanu.hookguard.controller;

import com.bhanu.hookguard.entity.WebhookEndpoint;
import com.bhanu.hookguard.service.WebhookEndpointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/endpoints")
public class WebhookEndpointController {

    private final WebhookEndpointService service;

    public WebhookEndpointController(WebhookEndpointService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WebhookEndpoint> createEndpoint(@RequestBody WebhookEndpoint endpoint){

        WebhookEndpoint savedEndpoint = service.createEndpoint(endpoint);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEndpoint);
    }

    @GetMapping
    public ResponseEntity<List<WebhookEndpoint>> getAllEndPoints(){
        List<WebhookEndpoint> endpoints = service.getAllEndpoints();
        return ResponseEntity.ok(endpoints);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebhookEndpoint> getEndPointById(@PathVariable Long id){
        return service.getEndpointById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WebhookEndpoint> updateEndpoint(@PathVariable Long id, @RequestBody WebhookEndpoint endpoint){
        return service.updateEndpoint(id, endpoint)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndpoint(@PathVariable Long id){
        boolean deleted = service.deleteEndpoint(id);

        if(!deleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
