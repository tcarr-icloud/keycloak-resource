package com.example.keycloakresource.keycloak.role;

import com.example.keycloakresource.keycloak.client.Attributes;

public class RoleRepresentation {
    public String id;
    public String name;
    public String description;
    public boolean scopeParamRequired;
    public boolean composite;
    public String[] composites;
    public boolean clientRole;
    public String containerId;
    public Attributes AttributesObject;
}
