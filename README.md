# Placement Portal Backend

Spring Boot backend application for managing student placement data.

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman

## Features
- Create Student
- Get All Students
- Get Student by ID
- Update Student
- Delete Student
- Validation & Exception Handling

## API Endpoints

| Method | Endpoint | Description |
|------|---------|-------------|
| POST | /students | Create student |
| GET | /students | Get all students |
| GET | /students/{id} | Get student by ID |
| PUT | /students/{id} | Update student |
| DELETE | /students/{id} | Delete student |

## How to Run
```bash
./mvnw spring-boot:run
