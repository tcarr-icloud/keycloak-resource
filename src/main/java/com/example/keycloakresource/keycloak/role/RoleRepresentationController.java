package com.example.keycloakresource.keycloak.role;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/keycloak/roles")
class RoleRepresentationController {
    private final RoleRepresentationService roleRepresentationService;

    RoleRepresentationController(RoleRepresentationService roleRepresentationService) {
        this.roleRepresentationService = roleRepresentationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleRepresentation> getRole(@RequestHeader("Authorization") String authorizationHeader, @PathVariable String id) {
        try {
            return ResponseEntity.ok().body(roleRepresentationService.getRoleById(authorizationHeader, id));
        } catch (HttpClientErrorException httpClientErrorException) {
            return ResponseEntity.status(httpClientErrorException.getStatusCode()).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<RoleRepresentation[]> getRoles(@RequestHeader("Authorization") String authorizationHeader) {
        return ResponseEntity.ok().body(roleRepresentationService.getRoles(authorizationHeader));
    }

}
