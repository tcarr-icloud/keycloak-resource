package com.example.keycloakresource.integration;

import com.example.keycloakresource.AccessTokenResponse;
import com.example.keycloakresource.keycloak.role.RoleRepresentation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleRepresentationTestsIT {
    @LocalServerPort
    private int port;

    @Test
    void getRolesExpectUnauthorized() {
        try {
            RestClient client = RestClient.create();
            client.get().uri("http://localhost:" + port + "/api/keycloak/roles").retrieve().toBodilessEntity();
            assert false;
        } catch (HttpClientErrorException httpClientErrorException) {
            assert httpClientErrorException.getStatusCode() == HttpStatus.UNAUTHORIZED;
        }
    }

    @Test
    void getRolesExpectSuccess() {
        RestClient client = RestClient.create();
        ResponseEntity<RoleRepresentation[]> roles = client.get().uri("http://localhost:" + port + "/api/keycloak/roles").header("Authorization", "Bearer " + getAccessToken()).retrieve().toEntity(RoleRepresentation[].class);
        assert roles.getStatusCode() == HttpStatus.OK;
        assert roles.getBody().length > 0;
    }

    @Test
    void getRoleByIdExpectSuccess() {
        RestClient client = RestClient.create();
        ResponseEntity<RoleRepresentation[]> roles = client.get().uri("http://localhost:" + port + "/api/keycloak/roles").header("Authorization", "Bearer " + getAccessToken()).retrieve().toEntity(RoleRepresentation[].class);
        assert roles.getStatusCode() == HttpStatus.OK;
        String idToGet = roles.getBody()[0].name();
        ResponseEntity<RoleRepresentation> role = client.get().uri("http://localhost:" + port + "/api/keycloak/roles/" + idToGet).header("Authorization", "Bearer " + getAccessToken()).retrieve().toEntity(RoleRepresentation.class);
        assert role.getStatusCode() == HttpStatus.OK;
        RoleRepresentation roleRepresentation = role.getBody();
        assert roleRepresentation.name().equals(idToGet);
    }

    @Test
    void getRoleByIdExpectNotFound() {
        try {
            RestClient client = RestClient.create();
            String idToGet = "-1L";
            client.get().uri("http://localhost:" + port + "/api/keycloak/roles/" + idToGet).header("Authorization", "Bearer " + getAccessToken()).retrieve().toBodilessEntity();
            assert false;
        } catch (HttpClientErrorException e) {
            assert e.getStatusCode() == HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            assert false;
        }
    }

    private String getAccessToken() {
        RestClient client = RestClient.create();
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "password");
        formData.add("client_id", "admin-cli");
        formData.add("username", "admin@demo.com");
        formData.add("password", "password");

        return client.post().uri("http://localhost:9090/realms/demo/protocol/openid-connect/token").contentType(MediaType.APPLICATION_FORM_URLENCODED).body(formData).retrieve().body(AccessTokenResponse.class).access_token();
    }

}
