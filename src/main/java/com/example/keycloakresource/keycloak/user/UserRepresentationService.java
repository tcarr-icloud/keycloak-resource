package com.example.keycloakresource.keycloak.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UserRepresentationService {
    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    public UserRepresentation getUserById(String accessToken, String id) {
        return RestClient.create()
                .get()
                .uri(authServerUrl + "/admin/realms/" + realm + "/users/" + id)
                .header("Authorization", accessToken)
                .retrieve()
                .body(UserRepresentation.class);
    }

    public UserRepresentation[] getUsers(String accessToken) {
        return RestClient.create()
                .get()
                .uri(authServerUrl + "/admin/realms/" + realm + "/users")
                .header("Authorization", accessToken)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

}
