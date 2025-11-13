package com.example.keycloakresource.integration;

import com.example.keycloakresource.AccessTokenResponse;
import com.example.keycloakresource.keycloak.role.RoleRepresentation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${oauth2_url}")
    private String oauth2Url;

    @Value("${oauth2_realm}")
    private String oauth2Realm;

    @Value("${oauth2_client_id}")
    private String oauth2ClientId;

    @Value("${oauth2_client_secret}")
    private String oauth2ClientSecret;

    @Value("${oauth2_client_username}")
    private String oauth2ClientUsername;

    @Value("${oauth2_grant_type:password}")
    private String oauth2GrantType;

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
        formData.add("grant_type", oauth2GrantType);
        formData.add("client_id", oauth2ClientId);
        formData.add("username", oauth2ClientUsername);
        formData.add("password", oauth2ClientSecret);

        return client.post().uri(oauth2Url + "/realms/" + oauth2Realm + "/protocol/openid-connect/token").contentType(MediaType.APPLICATION_FORM_URLENCODED).body(formData).retrieve().body(AccessTokenResponse.class).access_token();
    }

}
