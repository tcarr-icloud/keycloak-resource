package com.example.keycloakresource.keycloak.user;

import com.example.keycloakresource.keycloak.client.Attributes;

public class UserRepresentation {
    public String id;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public boolean emailVerified;
    public Attributes attributes;
    public UserProfileMetadata userProfileMetadata;
    public boolean enabled;
    public String self;
    public String origin;
    public long createdTimestamp;
    public boolean totp;
    public String federationLink;
    public String serviceAccountClientId;
    public CredentialRepresentation[] credentials;
    public String[] disabledCredentialTypes;
    public String[] requiredActions;
    public FederatedIdentityRepresentation[] federatedIdentities;
    public String[] realmRoles;
    public String[] clientRoles;
    public UserConsentRepresentation[] clientConsents;
    public int notBefore;
    public String[] applicationRoles;
    public String[] socialLinks;
    public String[] groups;
    public Object access;
}
