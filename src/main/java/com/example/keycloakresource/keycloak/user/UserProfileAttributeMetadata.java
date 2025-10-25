package com.example.keycloakresource.keycloak.user;

import java.util.Map;

public record UserProfileAttributeMetadata(String name, String displayName, Boolean required, Boolean readOnly,
                                           Map<Object, Object> annotations, Map<Object, Object> validators,
                                           String group, Boolean multiValued, String defaultValue) {
}
