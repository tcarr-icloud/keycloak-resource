package com.example.keycloakresource.keycloak.role;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
class RoleRepresentationService {
    @Value("${keycloak.auth.server.url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    public RoleRepresentation getRoleById(String accessToken, String id) {
        return RestClient.create()
                .get()
                .uri(authServerUrl + "/admin/realms/" + realm + "/roles/" + id)
                .header("Authorization", accessToken)
                .retrieve()
                .body(RoleRepresentation.class);
    }

    public RoleRepresentation[] getRoles(String accessToken) {
        return RestClient.create()
                .get()
                .uri(authServerUrl + "/admin/realms/" + realm + "/roles")
                .header("Authorization", accessToken)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

}
