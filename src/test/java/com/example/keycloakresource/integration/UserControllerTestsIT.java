package com.example.keycloakresource.integration;

import com.example.keycloakresource.users.UserDTO;
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

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTestsIT {
    @LocalServerPort
    private int port;

    @Test
    void performRequestToResourceExpectUnauthorized() {
        RestClient client = RestClient.create();
        try {
            client.get().uri("http://localhost:" + port + "/api/users").retrieve().toEntity(Object.class);
            fail();
        } catch (HttpClientErrorException e) {
            assert e.getStatusCode() == HttpStatus.UNAUTHORIZED;
        }
    }

    @Test
    void getAllowedUsersExpectSuccess() {
        RestClient client = RestClient.create();
        ResponseEntity<UserDTO[]> users = client.get().uri("http://localhost:" + port + "/api/users").header("Authorization", "Bearer " + getAccessToken()).retrieve().toEntity(UserDTO[].class);
        assert users.getStatusCode() == HttpStatus.OK;
        assert users.getBody().length > 0;
    }

    @Test
    void getAllowedUserByIdExpectSuccess() {
        RestClient client = RestClient.create();
        ResponseEntity<UserDTO[]> users = client.get().uri("http://localhost:" + port + "/api/users").header("Authorization", "Bearer " + getAccessToken()).retrieve().toEntity(UserDTO[].class);
        assert users.getStatusCode() == HttpStatus.OK;
        long userIdToGet = users.getBody()[0].id();
        ResponseEntity<UserDTO> user = client.get().uri("http://localhost:" + port + "/api/users/" + userIdToGet).header("Authorization", "Bearer " + getAccessToken()).retrieve().toEntity(UserDTO.class);
        assert user.getStatusCode() == HttpStatus.OK;
        UserDTO userDTO = user.getBody();
        assert userDTO.id() == userIdToGet;
    }

    @Test
    void getNotAllowedUserByIdExpectForbidden() {
        RestClient client = RestClient.create();
        long userIdToGet = -1L;
        try {
            client.get().uri("http://localhost:" + port + "/api/users/" + userIdToGet).header("Authorization", "Bearer " + getAccessToken()).retrieve().toBodilessEntity();
            fail();
        } catch (HttpClientErrorException e) {
            assert e.getStatusCode() == HttpStatus.NOT_FOUND;
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
