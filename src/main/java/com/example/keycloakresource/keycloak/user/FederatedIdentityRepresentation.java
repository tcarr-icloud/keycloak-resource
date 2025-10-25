package com.example.keycloakresource.keycloak.user;

public record FederatedIdentityRepresentation(String identityProvider, String userId, String userName) {
}

