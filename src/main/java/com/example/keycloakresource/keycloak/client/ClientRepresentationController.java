package com.example.keycloakresource.keycloak.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/keycloak/clients")
class ClientRepresentationController {
    private final ClientRepresentationService clientRepresentationService;

    ClientRepresentationController(ClientRepresentationService clientRepresentationService) {
        this.clientRepresentationService = clientRepresentationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientRepresentation> getClient(@RequestHeader("Authorization") String authorizationHeader, @PathVariable String id) {
        try {
            return ResponseEntity.ok().body(clientRepresentationService.getClientById(authorizationHeader, id));
        } catch (HttpClientErrorException httpClientErrorException) {
            return ResponseEntity.status(httpClientErrorException.getStatusCode()).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<ClientRepresentation[]> getClients(@RequestHeader("Authorization") String authorizationHeader) {
        return ResponseEntity.ok().body(clientRepresentationService.getClients(authorizationHeader));
    }

}
