package net.franzka.kaauth.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakJwtAuthenticationConverter extends JwtAuthenticationConverter {

    public KeycloakJwtAuthenticationConverter() {
        setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
    }

    private static class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
        @Override
        public Collection<GrantedAuthority> convert(Jwt jwt) {
            Map<String, Object> realmAccess = jwt.getClaim("realm_access");
            if (realmAccess == null || realmAccess.isEmpty()) {
                return List.of();
            }

            List<String> roles = (List<String>) realmAccess.get("roles");
            // Resource roles (par client)
            Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
            if (resourceAccess != null && resourceAccess.containsKey("vuejs")) {
                Map<String, Object> client = (Map<String, Object>) resourceAccess.get("vuejs");
                if (client.containsKey("roles")) {
                    roles.addAll((List<String>) client.get("roles"));
                }
            }

            return roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
        }
    }
}