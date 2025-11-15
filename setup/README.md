## Configuration

While developing this service, there are several external dependencies. Keycloak, Postgresql, Docker are a few.
In this directory, the docker-compose.yml file is the main file to start the applications required for this project.
The configuration is not secure and is intended for local development use only. **Do not use in production**.

### Quick Start

#### docker-compose.yml
1. docker-compose.yml, run it.  `docker compose up`
2. Connect to the Postgresql server. [pgAdmin](http://localhost:15432) or Intellij.
3. Create *keycloak* database in postgresql. `create database keycloak with owner postgres;`
4. Create *spring-keycloak* database in postgresql. `create database spring-keycloak with owner postgres;`
5. Restart docker compose. `ctrl-c; docker compose up --detach`
6. Verify all three services are started and running.

##### keycloak
7. Login to [Keycloak](http://localhost:8080) with credentials admin:password.
8. Go to _Manage realms_.
9. _Create realm_, Realm name: *development*, Enabled = On.
10. Go to _Clients_.
11. _Create_, Client ID: *api-client*.
12. _Create_, Client ID: *spa-client*.
13. Set Valid redirect URIs and Web Origins to *http://localhost:4200/*.
13. Go to _Users_.
11. _Add user_, Username and Email: *admin@development.com*, Email verified: On.
12. _Add user_, Username and Email: *api.user@development.com*, Email verified: On.
13. Set the passwords for both users. Select user, then the _Credentials_ tab. Set password to password and Temporary Off.
14. Login to [Security Admin Console](http://localhost:8080/admin/development/console/) with both users.

15. Open project in Intellij.
16. Copy the http-client.env.json to the project root.
17. Edit _Run/Debug configurations_, _spring-boot template_. Paste environment variable stringinto the environment variables configuration template.
18. Run/debug main class *KeycloakResourceApplication*.
20. Open *keycloak-resource.http* file. The second request gets a token. 
21. Once the you have a token, then call any of the other requests.

**Good Luck!**

### Environment variables
`
CORS_ALLOWED-ORIGINS=http://localhost:4200;KEYCLOAK_AUTH-SERVER-URL=http://localhost:8080;KEYCLOAK_REALM=development;SERVER_PORT=8081;SPRING_APPLICATION_NAME=spring-keycloak;SPRING_DATASOURCE_PASSWORD=password;SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/spring-keycloak;SPRING_DATASOURCE_USERNAME=postgres;SPRING_JPA_GENERATE-DDL=true;SPRING_JPA_HIBERNATE_DDL-AUTO=update;SPRING_JPA_SHOW-SQL=true;SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER-URI=http://localhost:8080/realms/development;SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK-SET-URI=http://localhost:8080/realms/development/protocol/openid-connect/certs
`