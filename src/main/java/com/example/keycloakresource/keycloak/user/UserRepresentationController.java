package com.example.keycloakresource.keycloak.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/keycloak/users")
class UserRepresentationController {
    private final UserRepresentationService userService;

    public UserRepresentationController(UserRepresentationService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    ResponseEntity<UserRepresentation> getUser(@RequestHeader("Authorization") String authorizationHeader, @PathVariable("id") String id) {
        try {
            return ResponseEntity.ok().body(userService.getUserById(authorizationHeader, id));
        } catch (HttpClientErrorException httpClientErrorException) {
            return ResponseEntity.status(httpClientErrorException.getStatusCode()).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("")
    ResponseEntity<UserRepresentation[]> getUsers(@RequestHeader("Authorization") String authorizationHeader) {
        return ResponseEntity.ok().body(userService.getUsers(authorizationHeader));
    }

}
