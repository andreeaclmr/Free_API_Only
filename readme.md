# Music Exchange - API Restful Project

## Objective
The project aims to connect musicians and managers, with the aim of helping the new musicians to get known.
The interaction takes place at the Admin level in the beginning, while working on a future version where both Musicians and Managers can create their own profiles and manage them as well.

## Tools & Tech
The project was build with SpringBoot Initializr version 3.3.6, JAR Packaging, 21 Java

### <ins>Back End</ins>
- [x] <img src="https://img.shields.io/badge/Intellij Idea-000?logo=intellij-idea&style=for-the-badge"/> 

- [x] <img src= "https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>

- [x] <img src= "https://badgen.net/badge/icon/maven?icon=maven&label"/>

### <ins>Data & APIs</ins>

- [x] <img src= "https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white"/>

- [x] <img src= "https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white"/>

- [x] <img src= "https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white"/>


### <ins>Misc</ins>

- [x] <img src="https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white"/>

- [x] <img src= "https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white"/>

- [x] <img src= "https://shields.io/badge/simple__diarizer-Trello-blue?logo=Trello&style=flat"/>

- [x] <img src= "https://img.shields.io/badge/Lucid-282C33?logo=lucid&logoColor=fff&style=for-the-badge"/>



## Dependencies
### Spring Boot Dependencies
- [x] spring-boot-starter-data-jpa
- [x] jackson-datatype-jsr310
- [x] spring-boot-starter-web
- [x] spring-boot-starter-validation

### Database Drivers
- [x] h2
- [x] postgresql
- [x] mysql-connector-j

### Testing Dependencies
- [x] spring-boot-starter-test
- [x] junit-jupiter-api
- [x] junit-jupiter-engine
- [x] mockito-core
- [x] mockito-junit-jupiter

### Lombok
- [x] lombok

### Springdoc OpenAPI
- [x] springdoc-openapi-starter-webmvc-ui

## Functionalities
- [x] Register Musicians, Search entire list, List by Name, Update and Delete
- [x] Register Managers, Search entire list, List by ID, Update and Delete
- [x] Connects to an API through JPA and H2
- [x] Each musician added to JPA receives an unique ID
- [x] CRUD tested with Postman
- [x] Using DTO Classes
- [x] Search by Status using Enum Class


## Tests
Pasos para ejecutar la aplicación y pasar los tests.

- [x] Musician Acceptance Test
- [] Tests Unitarios
- [] Global Exception Handling

## UML Diagram


## E/R Diagram
```mermaid
erDiagram
    MANAGER ||--o{ MUSICIAN : has
    MANAGER {
        int id
        String name
        String company
        String email
        String seeking_skills
    }
    MUSICIAN {
        int id
        String name
        String skills
        String link
        String photo
        LocalDate dateCreated
    }
```
## Enum and Filters
Managers have an extra filter and can be sorted by the status Active/ Inactive.
While retrieving data using the GET by Status endpoint, it is necessary to write the status in capslock.
The endpoint for this application is: localhost:8080/api/get/managers/status/ACTIVE

## Profiles
Explicación de los perfiles.


## Kanban with GitHub Projects

## API Documentation
This project uses [Swagger](https://swagger.io/) for documenting the API endpoints. Swagger provides an interactive interface to explore and test the APIs.
### Accessing the Documentation

After running the application, you can access the Swagger UI by visiting:
http://localhost:8080/swagger-ui.html


### Example Endpoints

- **Get All Managers:** `GET /api/get/managers`
- **Create Manager:** `POST /api/post/managers`
- **Delete Manager:** `DELETE /api/del/managers/{id}`

### Swagger UI Preview

Below is a preview of the Swagger UI interface:

![Swagger UI Screenshot1](path/to/your/screenshot.png)
![Swagger UI Screenshot2](path/to/your/screenshot.png)
![Swagger UI Screenshot3](path/to/your/screenshot.png)
![Swagger UI Screenshot4](path/to/your/screenshot.png)

### Schemas IU Preview
![Schemas UI Screenshot1](path/to/your/screenshot.png)

### Swagger Setup

This project uses **Springdoc OpenAPI** for Swagger integration. The configuration is minimal and handled automatically. Dependencies used:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.15</version>
</dependency>
```

## About Me
**Andreea Celmare**

[<img src="https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white" alt="GitHub" />](https://github.com/andreeaclmr) </br>
[<img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" />](https://www.linkedin.com/in/andreea-alina-celmare/)


## Special Thanks
Sergi Virgili & Amr Hefny from Factoria F5


