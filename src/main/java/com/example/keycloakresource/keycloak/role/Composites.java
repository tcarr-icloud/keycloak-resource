package com.example.keycloakresource.keycloak.role;

import java.util.Map;
import java.util.Set;

public record Composites(Set<String> realm, Map<Object, Object> client, Map<Object, Object> application) {
}
