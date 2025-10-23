package com.example.keycloakresource.keycloak.role;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
class RoleRepresentationController {
    private final RoleRepresentationService roleRepresentationService;

    RoleRepresentationController(RoleRepresentationService roleRepresentationService) {
        this.roleRepresentationService = roleRepresentationService;
    }

    @GetMapping("/{id}")
    public RoleRepresentation getRole(
            @RequestHeader("Authorization") String authorizationHeader, @PathVariable String id) {
        return roleRepresentationService.getRoleById(authorizationHeader, id);
    }

    @GetMapping
    public RoleRepresentation[] getRoles(@RequestHeader("Authorization") String authorizationHeader) {
        return roleRepresentationService.getRoles(authorizationHeader);
    }

}
