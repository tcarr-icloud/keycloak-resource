package com.example.keycloakresource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.apache.maven.model.Model;
//import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
@RequestMapping("/api/service")
class ServiceController {
    @Value("${app.version}")
    private String version;

    @RequestMapping("/version")
    String version() throws IOException {
        return version;
    }
}
