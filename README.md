# Keycloak Resource (Spring Boot)

RESTful resource server built with Spring Boot that integrates with Keycloak for authentication/authorization. It exposes endpoints to work with:
- Users in this service (`/api/users`)
- Keycloak Users (`/api/keycloak/users`)
- Keycloak Clients (`/api/keycloak/clients`)
- Keycloak Roles (`/api/keycloak/roles`)

The service is secured as an OAuth2 Resource Server (JWT) and expects a Bearer token issued by Keycloak.


## Stack
- Language: Java 21 (see `pom.xml` → `<java.version>21</java.version>`)
- Framework: Spring Boot 3.5.7 (Web, Security, OAuth2 Resource Server, Data JPA)
- Database Driver: PostgreSQL (runtime dependency)
- Build/Package: Maven (Maven Wrapper included: `mvnw`/`mvnw.cmd`)
- Testing: JUnit (Spring Boot Test, Spring Security Test), integration tests via Maven Failsafe (`*IT.java`)
- Container: Dockerfile provided


## Requirements
- Java 21 JDK
- Maven 3.9+ (or just use the Maven Wrapper `./mvnw`)
- PostgreSQL database (if you enable datasource properties)
- A running Keycloak instance with a realm/clients configured to issue JWTs for this API
    `bin/kc.sh start-dev --hostname keycloak --db postgres --db-url-host keycloak-postgres --db-username postgres --db-password password`

## Configuration
Application defaults (see `src/main/resources/application.properties`):
- `server.port=8081`
- `spring.jpa.show-sql=true`
- `spring.jpa.generate-ddl=true`
- `spring.jpa.hibernate.ddl-auto=update`
- `logging.level.org.springframework=TRACE`

Security/CORS:
- The app reads `cors.allowed-origins` property (in `KeycloakResourceConfiguration`) for CORS configuration.

OAuth2 Resource Server (JWT):
- Configure issuer/JWK set URIs via Spring properties (e.g., `spring.security.oauth2.resourceserver.jwt.issuer-uri` or `spring.security.oauth2.resourceserver.jwt.jwk-set-uri`). These are not set in `application.properties` by default.

Database:
- Configure `spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password` when persisting to PostgreSQL.

### Environment variables
Spring Boot supports relaxed binding for environment variables. Use uppercase with underscores. Examples:
- `SERVER_PORT` (maps to `server.port`)
- `CORS_ALLOWED-ORIGINS` (maps to `cors.allowed-origins`)
- `KEYCLOAK_AUTH-SERVER-URL`
- `KEYCLOAK_REALM`
- `SPRING_DATASOURCE_URL` (maps to `spring.datasource.url`)
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER_URI`
- `SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK_SET_URI`
- `SPRING_JPA_GENERATE-DDL`
- `SPRING_JPA_SHOW-SQL`
`
CORS_ALLOWED-ORIGINS=http://localhost:4200;KEYCLOAK_AUTH-SERVER-URL=http://localhost:8080;KEYCLOAK_REALM=development;SPRING_APPLICATION_NAME=spring-keycloak;SPRING_DATASOURCE_PASSWORD=password;SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/spring-keycloak;SPRING_DATASOURCE_USERNAME=postgres;SPRING_JPA_GENERATE-DDL=true;SPRING_JPA_HIBERNATE_DDL-AUTO=update;SPRING_JPA_SHOW-SQL=true;SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER-URI=http://keycloak:8080/realms/development;SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK-SET-URI=http://localhost:8080/realms/development/protocol/openid-connect/certs;SERVER_PORT=8081
`

### Enviornment variable for Tests
Tests requires the same variables as the application, plus OAuth2 client credentials to obtain a token from Keycloak. Example values for local testing:
- `OAUTH2_CLIENT_ID` (api-client)
- `OAUTH2_REALM` (development)
- `OAUTH2_URL` (http://localhost:8080)
- `OAUTH2_CLIENT_SECRET` (password)
- `OAUTH2_CLIENT_USERNAME` (api.user@development.com)
- `OAUTH2_GRANT_TYPE` (password)

## Endpoints (selected)
All endpoints require an `Authorization: Bearer <access_token>` header.

- `GET /api/users` — returns users in this service
- `GET /api/users/{id}` — returns a user by internal id
- `GET /api/keycloak/users` — returns users from Keycloak
- `GET /api/keycloak/users/{id}` — returns a Keycloak user by id
- `GET /api/keycloak/clients` — returns Keycloak clients
- `GET /api/keycloak/clients/{id}` — returns a Keycloak client by id
- `GET /api/keycloak/roles` — returns Keycloak roles
- `GET /api/keycloak/roles/{id}` — returns a Keycloak role by id

See `keycloak-resource.http` for example requests, including how to obtain a token from Keycloak and invoke these endpoints locally.


## Setup
1) Clone and enter the project
```
git clone <this-repo-url>
cd keycloak-resource
```

2) Configure environment (pick one):
- via properties: edit `src/main/resources/application.properties`
- via env vars: export variables as shown above

3) Ensure Keycloak is running and configured to issue tokens for this API.
   - From `keycloak-resource.http`, there are two sample realms shown (`development` on :8080 and `demo` on :9090). See TODOs to finalize which realm/client this project uses by default.


## Running the application

Using Maven wrapper (recommended):
```
./mvnw spring-boot:run
```

Build a jar and run:
```
./mvnw -DskipTests package
java -jar target/keycloak-resource-0.0.1-SNAPSHOT.jar
```

Specify configuration (examples):
```
export SERVER_PORT=8081
export CORS_ALLOWED_ORIGINS=http://localhost:4200
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/spring-keycloak
export SPRING_DATASOURCE_USERNAME=postgres
export SPRING_DATASOURCE_PASSWORD=password
export SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER_URI=http://127.0.0.1:9090/realms/demo
export SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK_SET_URI=http://127.0.0.1:9090/realms/demo/protocol/openid-connect/certs
./mvnw spring-boot:run
```


## Docker

Build image:
```
./mvnw -DskipTests package
docker build -t keycloak-resource:local .
```

Run container (example):
```
docker run --rm -p 8081:8081 \
  -e SERVER_PORT=8081 \
  -e CORS_ALLOWED_ORIGINS=http://localhost:4200 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/spring-keycloak \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=password \
  -e SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER_URI=http://127.0.0.1:9090/realms/demo \
  -e SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK_SET_URI=http://127.0.0.1:9090/realms/demo/protocol/openid-connect/certs \
  keycloak-resource:local
```

Note: The provided `Dockerfile` sets several env vars, but some names use hyphens which do not map as expected in Spring Boot environment binding. See TODOs.


## Scripts and useful commands
- Build: `./mvnw -DskipTests package`
- Run: `./mvnw spring-boot:run`
- Check dependencies tree: `./mvnw dependency:tree`
- Format (if you use a formatter plugin locally): TODO


## Tests
This project uses unit/integration tests with Spring Boot.

- Run all tests (includes Failsafe ITs):
```
./mvnw verify
```

- Only unit tests (skip integration tests):
```
./mvnw -DskipITs test
```

Integration test naming pattern is configured via Failsafe in `pom.xml` to include `**/*IT.java`.


## Project structure
```
keycloak-resource/
├─ Dockerfile
├─ keycloak-resource.http              # sample HTTP requests for Keycloak and this API
├─ pom.xml
├─ src/
│  ├─ main/java/com/example/keycloakresource/
│  │  ├─ KeycloakResourceApplication.java        # Spring Boot entry point
│  │  ├─ KeycloakResourceConfiguration.java      # Security/CORS configuration
│  │  ├─ KeycloakJwtAuthenticationConverter.java # (optional converter, currently not wired)
│  │  ├─ users/                                  # local user domain (JPA entity, controller/service)
│  │  └─ keycloak/                               # DTOs/controllers/services talking to Keycloak
│  └─ main/resources/
│     └─ application.properties
│
│  └─ test/java/com/example/keycloakresource/integration/  # integration tests (*IT.java)
└─ target/...
```


## License
The `pom.xml` does not currently declare a specific license.

TODO: Add a license (e.g., MIT/Apache-2.0) and include the license file and metadata in `pom.xml`.


## TODOs / Open items
- Reconcile Java versions: Dockerfile uses Java 21, `pom.xml` targets Java 17. Decide on one and align both.
- Fix Dockerfile env var names: replace hyphens with underscores, e.g.,
  - `SPRING_JPA_SHOW-SQL` → `SPRING_JPA_SHOW_SQL`
  - `SPRING_JPA_GENERATE-DDL` → `SPRING_JPA_GENERATE_DDL`
  - `SPRING_JPA_HIBERNATE_DDL-AUTO` → `SPRING_JPA_HIBERNATE_DDL_AUTO`
  - `SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER-URI` → `SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER_URI`
  - `SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK-SET-URI` → `SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK_SET_URI`
  - `KEYCLOAK_AUTH-SERVER-URL` → (not used directly by Spring; consider removing or mapping to your own property)
  - `CORS_ALLOWED-ORIGINS` → `CORS_ALLOWED_ORIGINS`
- Finalize and document the Keycloak realm/client settings used by default (the `.http` file shows both `development` on :8080 and `demo` on :9090).
- Add database migration tool (e.g., Flyway/Liquibase) if schema needs control in non-dev environments.
- Add CI workflow to run `./mvnw verify` on pushes/PRs.
