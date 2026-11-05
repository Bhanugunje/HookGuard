package com.bhanu.hookguard.service;

import com.bhanu.hookguard.entity.WebhookEvent;
import com.bhanu.hookguard.repository.WebhookEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WebhookEventService {

    private final WebhookEventRepository repository;

    public WebhookEventService(WebhookEventRepository repository){
        this.repository = repository;
    }

    public WebhookEvent createEvent(WebhookEvent event){
        event.setCreatedAt(LocalDateTime.now());
        return repository.save(event);
    }

    public List<WebhookEvent> getAllEvents(){
        return repository.findAll();
    }

    public Optional<WebhookEvent> getEventById(Long id){
        return repository.findById(id);
    }
}
