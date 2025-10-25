package com.example.keycloakresource.keycloak.user;

import java.util.Map;

public class CredentialRepresentation {
    public String id;
    public String type;
    public String userLabel;
    public Long createdDate;
    public String secretData;
    public String credentialData;
    public Integer priority;
    public String value;
    public Boolean temporary;
    public String device;
    public String hashedSaltedValue;
    public String salt;
    public Integer hashIterations;
    public Integer counter;
    public String algorithm;
    public Integer digits;
    public Integer period;
    public Map<String, Object> config;
    public String federationLink;
}
