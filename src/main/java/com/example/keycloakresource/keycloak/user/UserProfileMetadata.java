package com.example.keycloakresource.keycloak.user;

public record UserProfileMetadata(UserProfileAttributeMetadata[] attributes,
                                  UserProfileAttributeGroupMetadata[] groups) {
}

