# Spring Security with Spring Boot

A REST API built with **Spring Boot** demonstrating core **Spring Security** concepts.

## Features
- HTTP Basic Authentication
- Role-Based Authorization
- Form-Based Authentication
- In-memory user store (no real database)

## Tech Stack
- Java
- Spring Boot 4.0.3
- Spring Security 7.0.3
- Maven

## Endpoints
| Endpoint | Access |
|---|---|
| `/home` | Authenticated users |
| `/login` | Public |
| `/register` | Public |
| `/users/**` | ADMIN role only |
// for role based auth 
## How to Run
```bash
mvn spring-boot:run
```
Then visit `http://localhost:8080`

## Default Users
Configured via in-memory authentication with BCrypt password encoding.
