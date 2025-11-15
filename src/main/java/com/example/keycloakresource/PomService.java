package com.example.keycloakresource;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;

@Service
public class PomService {

    public String read(String propertyName) {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        try (FileReader fileReader = new FileReader("./pom.xml")) {
            Model model = reader.read(fileReader);

            if (propertyName != null) {
                switch (propertyName) {
                    case "name":
                        return model.getName();
                    case "version":
                        return model.getVersion();
                    case "groupId":
                        return model.getGroupId();
                    case "artifactId":
                        return model.getArtifactId();
                }
            }
        } catch (IOException | org.codehaus.plexus.util.xml.pull.XmlPullParserException e) {
            System.err.println(e.getMessage());
        }
        return "Unknown";
    }
}