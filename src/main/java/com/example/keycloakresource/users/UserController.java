package com.example.keycloakresource.users;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public UserDTO[] getUsers(@RequestHeader("Authorization") String authorizationHeader) {
        return userService.getUsers(authorizationHeader);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(
            @RequestHeader("Authorization") String authorizationHeader, @PathVariable("id") Long id) {
        return userService.getUserById(authorizationHeader, id);
    }

}
