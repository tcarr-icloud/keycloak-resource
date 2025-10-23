package com.example.keycloakresource.keycloak.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
class ClientRepresentationService {
    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    public ClientRepresentation getClientById(String accessToken, String id) {
        return RestClient.create()
                .get()
                .uri(authServerUrl + "/admin/realms/" + realm + "/clients/" + id)
                .header("Authorization", accessToken)
                .retrieve()
                .body(ClientRepresentation.class);
    }

    public ClientRepresentation[] getClients(String accessToken) {
        return RestClient.create()
                .get()
                .uri(authServerUrl + "/admin/realms/" + realm + "/clients")
                .header("Authorization", accessToken)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

}
