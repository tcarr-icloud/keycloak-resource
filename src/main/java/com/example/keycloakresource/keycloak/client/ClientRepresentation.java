package com.example.keycloakresource.keycloak.client;

import java.util.ArrayList;
import java.util.Map;

public record ClientRepresentation(String id, String clientId, String name, String description, String type,
                                   String rootUrl, String adminUrl, String baseUrl, Boolean surrogateAuthRequired,
                                   Boolean enabled, Boolean alwaysDisplayInConsole, String clientAuthenticatorType,
                                   String secret, String registrationAccessToken, String[] defaultRoles,
                                   String[] redirectUris, String[] webOrigins, Integer notBefore, Boolean bearerOnly,
                                   Boolean consentRequired, Boolean standardFlowEnabled, Boolean implicitFlowEnabled,
                                   Boolean directAccessGrantsEnabled, Boolean serviceAccountsEnabled,
                                   Boolean authorizationServicesEnabled, Boolean directGrantsOnly, Boolean publicClient,
                                   Boolean frontchannelLogout, String protocol, Map<Object, Object> attributes,
                                   Map<Object, Object> authenticationFlowBindingOverrides, Boolean fullScopeAllowed,
                                   Integer nodeReRegistrationTimeout, Map<Object, Object> registeredNodes,
                                   ArrayList<ProtocolMapperRepresentation> protocolMappers, String clientTemplate,
                                   Boolean useTemplateConfig, Boolean useTemplateScope, Boolean useTemplateMappers,
                                   String[] defaultClientScopes, String[] optionalClientScopes,
                                   Object authorizationSettings, Map<Object, Object> access, String origin) {
}
