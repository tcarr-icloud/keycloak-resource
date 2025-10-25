package com.example.keycloakresource.keycloak.user;

import java.util.Map;

public record UserProfileAttributeGroupMetadata(String name, String displayHeader, String displayDescription,
                                                Map<Object, Object> annotations) {
}
