package com.example.keycloakresource.keycloak.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/keycloak/users")
class UserRepresentationController {
    private final UserRepresentationService userService;

    public UserRepresentationController(UserRepresentationService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    UserRepresentation getUserById(
            @RequestHeader("Authorization") String authorizationHeader, @PathVariable("id") String id) {
        return userService.getUserById(authorizationHeader, id);
    }

    @GetMapping("")
    UserRepresentation[] getUsers(@RequestHeader("Authorization") String authorizationHeader) {
        return userService.getUsers(authorizationHeader);
    }

}
