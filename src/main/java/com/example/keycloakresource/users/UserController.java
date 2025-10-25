package com.example.keycloakresource.users;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<UserDTO[]> getUsers(@RequestHeader("Authorization") String authorizationHeader) {
        return ResponseEntity.ok().body(userService.getUsers(authorizationHeader));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@RequestHeader("Authorization") String authorizationHeader, @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(userService.getUserById(authorizationHeader, id));
        } catch (NoSuchElementException noSuchElementException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
