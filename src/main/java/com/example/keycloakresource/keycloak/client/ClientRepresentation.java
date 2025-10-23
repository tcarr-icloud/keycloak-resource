package com.example.keycloakresource.keycloak.client;

import java.util.ArrayList;

public class ClientRepresentation {
    public String id;
    public String clientId;
    public String name;
    public String rootUrl;
    public ArrayList<String> redirectUris = new ArrayList<>();
    public ArrayList<String> webOrigins = new ArrayList<>();
    public Attributes AttributesObject;
    public AuthenticationFlowBindingOverrides AuthenticationFlowBindingOverridesObject;
    public ArrayList<Object> protocolMappers = new ArrayList<>();
    public ArrayList<String> defaultClientScopes = new ArrayList<>();
    public ArrayList<String> optionalClientScopes = new ArrayList<>();
    public Access AccessObject;
    public String baseUrl;
    public boolean surrogateAuthRequired;
    public boolean enabled;
    public boolean alwaysDisplayInConsole;
    public String clientAuthenticatorType;
    public float notBefore;
    public boolean bearerOnly;
    public boolean consentRequired;
    public boolean standardFlowEnabled;
    public boolean implicitFlowEnabled;
    public boolean directAccessGrantsEnabled;
    public boolean serviceAccountsEnabled;
    public boolean publicClient;
    public boolean frontchannelLogout;
    public String protocol;
    public boolean fullScopeAllowed;
    public float nodeReRegistrationTimeout;
}
