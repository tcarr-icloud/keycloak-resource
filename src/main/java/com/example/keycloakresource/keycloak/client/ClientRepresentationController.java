package com.example.keycloakresource.keycloak.client;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/keycloak/clients")
class ClientRepresentationController {
    private final ClientRepresentationService clientRepresentationService;

    ClientRepresentationController(ClientRepresentationService clientRepresentationService) {
        this.clientRepresentationService = clientRepresentationService;
    }

    @GetMapping("/{id}")
    public ClientRepresentation getClient(
            @RequestHeader("Authorization") String authorizationHeader, @PathVariable String id) {
        return clientRepresentationService.getClientById(authorizationHeader, id);
    }

    @GetMapping
    public ClientRepresentation[] getAll(@RequestHeader("Authorization") String authorizationHeader) {
        return clientRepresentationService.getClients(authorizationHeader);
    }

}
