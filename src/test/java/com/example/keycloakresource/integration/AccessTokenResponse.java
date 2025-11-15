package com.example.keycloakresource.integration;

public record AccessTokenResponse(String access_token, String token_type, int not_before_policy, String session_state,
                                  String scope) {
}
