package com.bhanu.hookguard.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class WebhookDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private WebhookEvent event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endpoint_id", nullable = false)
    private WebhookEndpoint endpoint;

    private String status = "PENDING";

    private int attemptCount = 0;

    private Integer responseStatusCode;

    @Column(columnDefinition = "TEXT")
    private String responseBody;

    private LocalDateTime createdAt;

    private LocalDateTime lastAttemptAt;

    private LocalDateTime nextAttemptAt;

    public WebhookDelivery(){
    }

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public WebhookEvent getEvent(){
        return event;
    }

    public void setEvent(WebhookEvent event){
        this.event = event;
    }

    public WebhookEndpoint getEndpoint(){
        return endpoint;
    }

    public void setEndpoint(WebhookEndpoint endpoint){
        this.endpoint = endpoint;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public int getAttemptCount(){
        return attemptCount;
    }

    public void setAttemptCount(int attemptCount){
        this.attemptCount = attemptCount;
    }

    public Integer getResponseStatusCode(){
        return responseStatusCode;
    }

    public void setResponseStatusCode(Integer responseStatusCode){
        this.responseStatusCode = responseStatusCode;
    }

    public String getResponseBody(){
        return responseBody;
    }

    public void setResponseBody(String responseBody){
        this.responseBody = responseBody;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastAttemptAt() {
        return lastAttemptAt;
    }

    public void setLastAttemptAt(LocalDateTime lastAttemptAt) {
        this.lastAttemptAt = lastAttemptAt;
    }

    public LocalDateTime getNextAttemptAt() {
        return nextAttemptAt;
    }

    public void setNextAttemptAt(LocalDateTime nextAttemptAt) {
        this.nextAttemptAt = nextAttemptAt;
    }
}
