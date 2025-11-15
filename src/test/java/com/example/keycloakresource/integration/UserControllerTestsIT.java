package com.example.keycloakresource.integration;

import com.example.keycloakresource.users.UserDTO;
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
class UserControllerTestsIT {
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
    void getUsersExpectUnauthorized() {
        try {
            RestClient client = RestClient.create();
            client.get().uri("http://localhost:" + port + "/api/users").retrieve().toEntity(Object.class);
            assert false;
        } catch (HttpClientErrorException e) {
            assert e.getStatusCode() == HttpStatus.UNAUTHORIZED;
        }
    }

    @Test
    void getUsersExpectSuccess() {
        RestClient client = RestClient.create();
        ResponseEntity<UserDTO[]> users = client.get().uri("http://localhost:" + port + "/api/users").header("Authorization", "Bearer " + getAccessToken()).retrieve().toEntity(UserDTO[].class);
        assert users.getStatusCode() == HttpStatus.OK;
        assert users.getBody().length >= 0;
    }

    @Test
    void getUserByIdExpectSuccess() {
        RestClient client = RestClient.create();
        ResponseEntity<UserDTO[]> users = client.get().uri("http://localhost:" + port + "/api/users").header("Authorization", "Bearer " + getAccessToken()).retrieve().toEntity(UserDTO[].class);
        assert users.getStatusCode() == HttpStatus.OK;
        if (users.getBody().length == 0) {
            return;
        }
        long userIdToGet = users.getBody()[0].id();
        ResponseEntity<UserDTO> user = client.get().uri("http://localhost:" + port + "/api/users/" + userIdToGet).header("Authorization", "Bearer " + getAccessToken()).retrieve().toEntity(UserDTO.class);
        assert user.getStatusCode() == HttpStatus.OK;
        UserDTO userDTO = user.getBody();
        assert userDTO.id() == userIdToGet;
    }

    @Test
    void getUserByIdExpectNotFound() {
        try {
            RestClient client = RestClient.create();
            long userIdToGet = -1L;
            client.get().uri("http://localhost:" + port + "/api/users/" + userIdToGet).header("Authorization", "Bearer " + getAccessToken()).retrieve().toBodilessEntity();
            assert false;
        } catch (HttpClientErrorException e) {
            assert e.getStatusCode() == HttpStatus.NOT_FOUND;
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
