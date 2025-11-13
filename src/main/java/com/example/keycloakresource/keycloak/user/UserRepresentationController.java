package com.example.keycloakresource.keycloak.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/keycloak/users")
class UserRepresentationController {
    private final UserRepresentationService userRepresentationService;

    public UserRepresentationController(UserRepresentationService userRepresentationService) {
        this.userRepresentationService = userRepresentationService;
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getUser(@RequestHeader("Authorization") String authorizationHeader, @PathVariable("id") String id) {
        try {
            return ResponseEntity.ok().body(userRepresentationService.getUserById(authorizationHeader, id));
        } catch (HttpClientErrorException httpClientErrorException) {
            return ResponseEntity.status(httpClientErrorException.getStatusCode()).build();
        } catch (UserRepresentationServiceForbiddenException userRepresentationServiceForbiddenException) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).build();
        }
    }

    @GetMapping("")
    ResponseEntity<?> getUsers(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            return ResponseEntity.ok().body(userRepresentationService.getUsers(authorizationHeader));
        } catch (UserRepresentationServiceForbiddenException userRepresentationServiceForbiddenException) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).build();
        }
    }
}
