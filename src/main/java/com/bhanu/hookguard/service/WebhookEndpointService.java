package com.bhanu.hookguard.service;

import com.bhanu.hookguard.entity.WebhookEndpoint;
import com.bhanu.hookguard.repository.WebhookEndpointRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebhookEndpointService {

    private final WebhookEndpointRepository repository;

    public WebhookEndpointService(WebhookEndpointRepository repository){
        this.repository = repository;
    }

    public WebhookEndpoint createEndpoint(WebhookEndpoint endpoint){
        return repository.save(endpoint);
    }

    public List<WebhookEndpoint> getAllEndpoints(){
        return repository.findAll();
    }

    public Optional<WebhookEndpoint> getEndpointById(Long id){
        return repository.findById(id);
    }

    public Optional<WebhookEndpoint> updateEndpoint(Long id, WebhookEndpoint updatedEndpoint){
        return repository.findById(id)
                .map(existingEndpoint -> {
                    existingEndpoint.setName(updatedEndpoint.getName());
                    existingEndpoint.setUrl(updatedEndpoint.getUrl());
                    existingEndpoint.setActive(updatedEndpoint.isActive());

                    return repository.save(existingEndpoint);
                });
    }

    public boolean deleteEndpoint(Long id){
        if(!repository.existsById(id)){
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}



