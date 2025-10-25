package com.example.keycloakresource.keycloak.user;

public record SocialLinkRepresentation(String socialProvider, String socialUserId, String socialUsername) {
}
