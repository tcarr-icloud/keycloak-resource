package com.example.keycloakresource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/service")
class ServiceController {
    private final PomService pomService;

    ServiceController(PomService pomService) {
        this.pomService = pomService;
    }

    @RequestMapping("/version")
    String version() throws IOException {
        return pomService.read("version");
    }
}
