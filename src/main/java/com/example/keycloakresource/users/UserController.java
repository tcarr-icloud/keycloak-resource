package com.example.keycloakresource.users;

import com.example.keycloakresource.keycloak.user.UserRepresentationServiceForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<?> getUsers(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            return ResponseEntity.ok().body(userService.getUsers(authorizationHeader));
        } catch (UserRepresentationServiceForbiddenException userRepresentationServiceForbiddenException) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN.value())
                    .body(new HttpErrorResponse(HttpStatus.FORBIDDEN.value(), userRepresentationServiceForbiddenException.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@RequestHeader("Authorization") String authorizationHeader, @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(userService.getUserById(authorizationHeader, id));
        } catch (NoSuchElementException noSuchElementException) {
            return ResponseEntity.notFound().build();
        } catch (UserRepresentationServiceForbiddenException userRepresentationServiceForbiddenException) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN.value())
                    .body(new HttpErrorResponse(HttpStatus.FORBIDDEN.value(), userRepresentationServiceForbiddenException.getMessage()));
        }
    }

}
