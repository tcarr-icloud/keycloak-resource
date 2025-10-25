package com.example.keycloakresource.keycloak.user;

import java.util.List;
import java.util.Map;
import java.util.Set;

public record UserRepresentation(String id, String username, String firstName, String lastName, String email,
                                 Boolean emailVerified, Map<Object, Object> attributes,
                                 UserProfileMetadata userProfileMetadata, Boolean enabled, String self, String origin,
                                 Long createdTimestamp, Boolean totp, String federationLink,
                                 String serviceAccountClientId, List<CredentialRepresentation> credentials,
                                 Set<String> disabledCredentialTypes, List<String> requiredActions,
                                 List<FederatedIdentityRepresentation> federatedIdentities, List<String> realmRoles,
                                 Map<Object, Object> clientRoles, List<UserConsentRepresentation> clientConsents,
                                 Integer notBefore, Map<Object, Object> applicationRoles,
                                 List<SocialLinkRepresentation> socialLinks, List<String> groups,
                                 Map<Object, Object> access) {
}
