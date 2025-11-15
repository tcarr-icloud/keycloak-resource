## Quick start
**Do not use in production**
The configuration is not secure and is intended for local development use only. 

Keycloak is a required dependency. You can run Keycloak using Docker Compose along with Postgresql and pgAdmin.
[DockerComposeWithPgAdminPostgresqlKeycloak.yml](DockerComposeWithPgAdminPostgresqlKeycloak.yml)

### PFX file
A PFX file, also known as a PKCS#12 file, is a binary format commonly used to store cryptographic objects like certificates and private keys in a single, password-protected file. PFX files can be created using tools like OpenSSL or graphical utilities like Keystore Explorer.

1. Generate a PFX file using openssl, Keystore Explorer, etc.
2. Use _password_ as the keystore password.
3. Rename the file to _keycloak.pfx_.
4. Copy the file to the _${projectRoot}/setup_ directory.

### docker compose

1. [DockerComposeWithPgAdminPostgresqlKeycloak](DockerComposeWithPgAdminPostgresqlKeycloak.yml)  `docker compose -f DockerComposeWithPgAdminPostgresqlKeycloak.yml up`
2. Connect to the Postgresql server. [pgAdmin](http://localhost:15432)
3. Create *keycloak* database. `create database keycloak with owner postgres;`
4. Create *spring-keycloak* database. `create database spring-keycloak with owner postgres;`
5. Restart docker compose. `docker compose -f DockerComposeWithPgAdminPostgresqlKeycloak.yml up --detach`

### keycloak

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
13. Set the passwords for both users. Select user, then the _Credentials_ tab. Set password to password and Temporary
    Off.
14. Login to [Security Admin Console](http://localhost:8080/admin/development/console/) with both users.

#### spring-keycloak

15. Open project in Intellij.
16. Copy the http-client.env.json to the project root.
17. Edit _Run/Debug configurations_, _spring-boot template_. Paste environment variable stringinto the environment
    variables configuration template.
18. Run/debug main class *KeycloakResourceApplication*.
20. Open *keycloak-resource.http* file. The second request gets a token.
21. Once the you have a token, then call any of the other requests.

**Good Luck!**

### Environment variables

`
CORS_ALLOWED-ORIGINS=http://localhost:4200;KEYCLOAK_AUTH-SERVER-URL=http://localhost:8080;KEYCLOAK_REALM=development;SERVER_PORT=8081;SPRING_APPLICATION_NAME=spring-keycloak;SPRING_DATASOURCE_PASSWORD=password;SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/spring-keycloak;SPRING_DATASOURCE_USERNAME=postgres;SPRING_JPA_GENERATE-DDL=true;SPRING_JPA_HIBERNATE_DDL-AUTO=update;SPRING_JPA_SHOW-SQL=true;SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER-URI=http://localhost:8080/realms/development;SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK-SET-URI=http://localhost:8080/realms/development/protocol/openid-connect/certs
`