# Music Quality Settings Microservice

This project is a Spring Boot-based microservice designed to manage quality settings for a system. It demonstrates the following key features:

1. **A Java Class**: `QualitySettings`, which defines `minBitrate` and `maxBitrate` as instance variables.
2. **A Configuration Class**: `QualityConfiguration`, which binds default values for the `minBitrate` and `maxBitrate` settings using Spring Boot's `@ConfigurationProperties`.
3. **A REST Controller**: `QualityController`, which provides a GET endpoint (`/quality-settings`) to retrieve the current quality settings.
4. **A Properties File**: Defines default values for `minBitrate` and `maxBitrate`.

---

## Project Structure

```
quality-settings-microservice/
├── src/main/java/
│   ├── com.example.qualitysettings/
│       ├── QualitySettings.java
│       ├── QualityConfiguration.java
│       ├── QualityController.java
├── src/main/resources/
│   ├── application.properties
├── pom.xml
```

### Explanation of Components

1. **`QualitySettings`**:
   - A simple Java class with two instance variables: `minBitrate` and `maxBitrate`.
   - Includes necessary constructors, getter, and setter methods.

2. **`QualityConfiguration`**:
   - A Spring Boot Configuration class annotated with `@ConfigurationProperties`.
   - Reads the default values for `minBitrate` and `maxBitrate` from the `application.properties` file.

3. **`QualityController`**:
   - A REST Controller class annotated with `@RestController`.
   - Provides a GET endpoint at `/quality-settings`.
   - Returns a `QualitySettings` object populated with values from `QualityConfiguration`.

4. **Properties File (`application.properties`)**:
   - Stores the default values for `minBitrate` and `maxBitrate`.
   - Example:
     ```properties
     quality.minBitrate=100
     quality.maxBitrate=1000
     ```

---

## Setup and Execution

### Prerequisites

- Java 11 or higher
- Maven
- Spring Boot

### Steps to Run the Project

1. Clone the repository.
   ```bash
   git clone <repository_url>
   cd quality-settings-microservice
   ```

2. Build the project using Maven.
   ```bash
   mvn clean install
   ```

3. Run the Spring Boot application.
   ```bash
   mvn spring-boot:run
   ```

4. Access the REST endpoint.
   - URL: `http://localhost:8080/quality-settings`
   - The endpoint will return the `minBitrate` and `maxBitrate` values as a JSON response.

### Example Response
```json
{
    "minBitrate": 100,
    "maxBitrate": 1000
}
```

---

## Key Features

- Centralized configuration management using `@ConfigurationProperties`.
- REST API to expose configuration values.
- Adheres to Spring Boot best practices, including clear package organization and annotations.
- Easy extensibility for additional configuration or endpoints.

---

## Dependencies

This project uses the following dependencies:

- **Spring Boot Starter Web**: For building the REST API.
- **Spring Boot Starter Configuration Processor**: For enabling `@ConfigurationProperties`.
- **Spring Cloud Config (Optional)**: For centralized configuration management.

Add these dependencies in the `pom.xml`:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-configuration-processor</artifactId>
        <optional>true</optional>
    </dependency>
    <!-- Optional: Spring Cloud Config -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
</dependencies>
```

---

## Customization

- Update `application.properties` to modify default `minBitrate` and `maxBitrate` values.
- Extend the `QualityController` to include additional endpoints for updating or validating the bitrate values.

---

## Future Enhancements

- Implement centralized configuration management with Spring Cloud Config.
- Add input validation for `minBitrate` and `maxBitrate` values.
- Provide a POST endpoint to update quality settings dynamically.
- Integrate authentication and authorization for secure API access.
