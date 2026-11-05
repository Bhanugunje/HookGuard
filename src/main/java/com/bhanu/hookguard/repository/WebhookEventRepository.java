package com.bhanu.hookguard.repository;

import com.bhanu.hookguard.entity.WebhookEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebhookEventRepository extends JpaRepository<WebhookEvent, Long> {

}
