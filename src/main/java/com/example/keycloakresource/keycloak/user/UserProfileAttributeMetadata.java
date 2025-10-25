package com.example.keycloakresource.keycloak.user;

import java.util.Map;

public class UserProfileAttributeMetadata {
    public String name;
    public String displayName;
    public Boolean required;
    public Boolean readOnly;
    public Map<Object, Object> annotations;
    public Map<Object, Object> validators;
    public String group;
    public Boolean multiValued;
    public String defaultValue;
}
