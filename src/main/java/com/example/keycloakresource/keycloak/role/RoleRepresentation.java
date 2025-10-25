package com.example.keycloakresource.keycloak.role;

import java.util.Map;

public record RoleRepresentation(String id, String name, String description, boolean scopeParamRequired,
                                 boolean composite, Composites composites, boolean clientRole, String containerId,
                                 Map<Object, Object> attributes) {
}
