# HookGuard — Webhook Reliability Platform

HookGuard is a backend application built using Java, Spring Boot, and MySQL to manage webhook endpoints and deliver event notifications to registered applications.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs

## Architecture

The application follows a layered architecture:

Controller → Service → Repository → Database

## Features

### Phase 1 — Backend Foundation (Completed)

- Register webhook endpoints.
- Retrieve all registered endpoints.
- Retrieve an endpoint by ID.
- Update webhook endpoints.
- Delete webhook endpoints.
- MySQL database integration.

### Phase 2 — Webhook Delivery Engine (In Progress)

- Create webhook events.
- Retrieve all events.
- Retrieve events by ID.
- Track webhook deliveries.
- Send HTTP POST requests to registered endpoints.
- Record delivery responses.

### Phase 3 — Reliability and Retry Mechanism (Planned)

- Automatic retries.
- Exponential backoff.
- HTTP timeout handling.
- Idempotency.

### Phase 4 — Delivery History (Planned)

- Delivery attempt history.
- HTTP response tracking.
- Pagination and filtering.

### Phase 5 — Backend Engineering (Planned)

- Input validation.
- Global exception handling.
- Unit and integration testing.
- Swagger/OpenAPI documentation.

### Phase 6 — Dashboard and Deployment (Planned)

- Dashboard.
- Docker integration.
- Deployment.
- Architecture documentation.

## Project Status

- Phase 1: Completed.
- Phase 2: In Progress.

## Running Locally

1. Clone this repository.
2. Configure your MySQL database.
3. Set the `DB_PASSWORD` environment variable.
4. Run the Spring Boot application.

The application runs on port 8081.

## Author

Bhanu Gunje
