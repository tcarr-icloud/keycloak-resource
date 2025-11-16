package com.example.keycloakresource.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class KeycloakResourceApplicationIT {
    @LocalServerPort
    private int port;

    @Test
    void integrationTest() {
    }

}
