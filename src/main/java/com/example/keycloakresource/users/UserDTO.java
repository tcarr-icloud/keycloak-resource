package com.example.keycloakresource.users;

public record UserDTO(long id,
                      String keycloakUserId,
                      String username,
                      String firstName,
                      String lastName,
                      String email,
                      Boolean enabled) {
}
