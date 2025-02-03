
# Event Registration System with Visitor Badge Generation

The Event Registration System with Visitor Badge Generation is a web application designed to streamline event registrations. It enables users to register for events by filling out a form with their personal details, including their name, email, phone number, and photo.

---

## Getting Started

## Clone the Repository
```
git clone https://github.com/YujenM/Event-Registration-System-with-Visitor-Badge-Generation.git
```
## ConFigure the Database
```
CREATE USER badgeSystem WITH PASSWORD 'password';
CREATE DATABASE badge_system_db WITH TEMPLATE template0 OWNER badgeSystem;

-- Connect to the database
\c badge_system_db;

-- Grant privileges to the user
ALTER DEFAULT PRIVILEGES FOR ROLE badgeSystem IN SCHEMA public GRANT ALL ON TABLES TO badgeSystem;
ALTER DEFAULT PRIVILEGES FOR ROLE badgeSystem IN SCHEMA public GRANT ALL ON SEQUENCES TO badgeSystem;

-- Create visitors table
CREATE TABLE visitors (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE NOT NULL,
    photo_path VARCHAR(255)
);
```

## src/main/resources/application.properties

```
# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/badge_system_db
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect


# # JPA & Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true             
spring.jpa.properties.hibernate.format_sql=true

# application.properties

spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=2MB
spring.servlet.multipart.max-request-size=2MB

spring.web.cors.allowed-origins=http://localhost:5174
spring.web.cors.allowed-methods=GET,POST,PUT,DELETE,OPTIONS
spring.web.cors.allowed-headers=*
spring.web.cors.allow-credentials=true

```

## Build the project
```
mvn clean install

```

## Run the application
```
mvn spring-boot:run
```







