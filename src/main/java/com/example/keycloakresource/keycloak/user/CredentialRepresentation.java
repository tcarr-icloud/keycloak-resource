package com.example.keycloakresource.keycloak.user;

import java.util.Map;

public record CredentialRepresentation(String id, String type, String userLabel, Long createdDate, String secretData,
                                       String credentialData, Integer priority, String value, Boolean temporary,
                                       String device, String hashedSaltedValue, String salt, Integer hashIterations,
                                       Integer counter, String algorithm, Integer digits, Integer period,
                                       Map<String, Object> config, String federationLink) {
}
