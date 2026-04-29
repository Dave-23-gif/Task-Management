# Task Management System API

A professional backend Task Management System built with Java and Spring Boot.
This project demonstrates modern backend architecture, RESTful API design, DTO-based communication, entity relationships, validation, exception handling, and layered service architecture.

---

# Features

## User Management

* Create users
* Get all users
* Get user by ID
* Delete users
* Email uniqueness validation

## Task Management

* Create tasks
* Get all tasks
* Get task by ID
* Update task status
* Delete tasks
* Assign tasks to users
* Get tasks by assigned user

## Backend Features

* RESTful APIs
* DTO pattern
* MapStruct mapping
* Global exception handling
* Request validation
* UUID-based identifiers
* JPA entity relationships
* Layered architecture
* Custom exception handling

---

# Technologies Used

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL / MySQL
* Lombok
* MapStruct
* Maven
* Hibernate

---

# Project Structure

```text
src/main/java
│
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── exception
└── enums
```

---

# Entity Relationship

```text
User
 └── One-to-Many → Tasks

Task
 └── Many-to-One → User
```

---

# API Endpoints

## User Endpoints

| Method | Endpoint        | Description    |
| ------ | --------------- | -------------- |
| POST   | /api/users      | Create user    |
| GET    | /api/users      | Get all users  |
| GET    | /api/users/{id} | Get user by ID |
| DELETE | /api/users/{id} | Delete user    |

---

## Task Endpoints

| Method | Endpoint                 | Description        |
| ------ | ------------------------ | ------------------ |
| POST   | /api/tasks               | Create task        |
| GET    | /api/tasks               | Get all tasks      |
| GET    | /api/tasks/{id}          | Get task by ID     |
| PATCH  | /api/tasks/{id}/status   | Update task status |
| DELETE | /api/tasks/{id}          | Delete task        |
| GET    | /api/tasks/user/{userId} | Get tasks by user  |

---

# Example Request

## Create Task

```json
{
  "title": "Finish Backend Project",
  "description": "Complete task management backend",
  "dueDate": "2026-05-15",
  "assignedUserId": "USER-UUID"
}
```

---

# Validation & Exception Handling

The project includes:

* Request validation using Jakarta Validation
* Global exception handling using `@ControllerAdvice`
* Custom exceptions:

  * `EmailAlreadyExistsException`
  * `ResourceNotFoundException`

---

# Future Improvements

* Authentication & Authorization (JWT)
* Pagination & Sorting
* Search & Filtering
* Role-based access control
* Docker support
* Unit & Integration testing
* Swagger/OpenAPI documentation

---

# Running the Project

## Clone Repository

```bash
git clone <repository-url>
```

## Navigate Into Project

```bash
cd task-management-system
```

## Run Application

```bash
./mvnw spring-boot:run
```

---

# Author

David Chikamai

---
