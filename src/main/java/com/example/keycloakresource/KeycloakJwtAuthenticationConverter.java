package com.example.keycloakresource;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final JwtGrantedAuthoritiesConverter defaultGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = Stream.concat(defaultGrantedAuthoritiesConverter.convert(jwt).stream(), extractRealmRoles(jwt).stream()).collect(Collectors.toSet());
        return new JwtAuthenticationToken(jwt, authorities);
    }

    private Collection<? extends GrantedAuthority> extractRealmRoles(Jwt jwt) {
        System.out.println("*************************** enter extractRealmRoles");
        if (jwt.hasClaim("realm_access")) {
            Object realmAccess = jwt.getClaim("realm_access");
            if (realmAccess instanceof java.util.Map) {
                java.util.Map<String, Object> realmAccessMap = (java.util.Map<String, Object>) realmAccess;
                if (realmAccessMap.containsKey("roles")) {
                    Object roles = realmAccessMap.get("roles");
                    if (roles instanceof java.util.Collection) {
                        return ((java.util.Collection<String>) roles).stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase())) // Prefix with ROLE_
                                .collect(Collectors.toSet());
                    }
                }
            }
        }
        return Collections.emptySet();
    }
}
