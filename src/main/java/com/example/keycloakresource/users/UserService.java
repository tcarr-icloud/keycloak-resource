package com.example.keycloakresource.users;

import com.example.keycloakresource.keycloak.user.UserRepresentation;
import com.example.keycloakresource.keycloak.user.UserRepresentationService;
import com.example.keycloakresource.keycloak.user.UserRepresentationServiceForbiddenException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
class UserService {
    private final UserRepository userRepository;
    private final UserRepresentationService userRepresentationService;

    UserService(UserRepository userRepository, UserRepresentationService userRepresentationService) {
        this.userRepository = userRepository;
        this.userRepresentationService = userRepresentationService;
    }

    public UserDTO getUserById(String authorizationHeader, Long id) {
        User user = userRepository.findById(id).orElseThrow();
        UserRepresentation userRepresentation = null;
        if (user.getKeycloakUserId() != null) {
            userRepresentation = userRepresentationService.getUserById(authorizationHeader, user.getKeycloakUserId());
        }
        return toUserDTO(user, userRepresentation);
    }

    public UserDTO[] getUsers(String authorizationHeader) throws UserRepresentationServiceForbiddenException {
        try {
            Map<String, UserRepresentation> userRepresentations = new HashMap<>();
            Arrays.stream(userRepresentationService.getUsers(authorizationHeader))
                    .forEach((userRepresentation) ->
                            userRepresentations.put(userRepresentation.id(), userRepresentation));

            return userRepository.findAll().stream().map(user -> {
                UserRepresentation userRepresentation = userRepresentations.get(user.getKeycloakUserId());
                return toUserDTO(user, userRepresentation);
            }).distinct().toArray(UserDTO[]::new);
        } catch (UserRepresentationServiceForbiddenException userRepresentationServiceForbiddenException) {
            throw userRepresentationServiceForbiddenException;
        }
    }

    private UserDTO toUserDTO(User user, UserRepresentation userRepresentation) {
        if (userRepresentation == null) {
            return new UserDTO(user.getId(), null, null, null, null, null, null);
        } else {
            return new UserDTO(user.getId(), userRepresentation.id(), userRepresentation.username(), userRepresentation.firstName(), userRepresentation.lastName(), userRepresentation.email(), userRepresentation.enabled());
        }
    }

}
