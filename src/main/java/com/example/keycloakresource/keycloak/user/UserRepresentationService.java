package com.example.keycloakresource.keycloak.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UserRepresentationService {
    @Value("${keycloak.auth.server.url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    public UserRepresentation getUserById(String accessToken, String id) throws UserRepresentationServiceForbiddenException {
        return RestClient.create()
                .get()
                .uri(authServerUrl + "/admin/realms/" + realm + "/users/" + id)
                .header("Authorization", accessToken)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new UserRepresentationServiceForbiddenException("Unable to retrieve user representation");
                })
                .body(UserRepresentation.class);
    }

    public UserRepresentation[] getUsers(String accessToken) throws UserRepresentationServiceForbiddenException {
        return RestClient.create().get().uri(authServerUrl + "/admin/realms/" + realm + "/users").header("Authorization", accessToken).retrieve().onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
            throw new UserRepresentationServiceForbiddenException("Unable to retrieve user representations");
        }).body(new ParameterizedTypeReference<>() {
        });
    }

}
