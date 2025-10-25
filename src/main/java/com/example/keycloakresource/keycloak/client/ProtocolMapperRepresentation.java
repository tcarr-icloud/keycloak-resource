package com.example.keycloakresource.keycloak.client;

import java.util.Map;

public record ProtocolMapperRepresentation(String id, String name, String protocol, String protocolMapper,
                                           Boolean consentRequired, String consentText,
                                           Map<Object, Object> config) {
}
