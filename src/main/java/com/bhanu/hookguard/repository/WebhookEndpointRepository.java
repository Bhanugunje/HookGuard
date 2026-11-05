package com.bhanu.hookguard.repository;

import com.bhanu.hookguard.entity.WebhookEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebhookEndpointRepository
    extends JpaRepository<WebhookEndpoint, Long> {

}
