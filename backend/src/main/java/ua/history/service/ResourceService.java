package ua.history.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class ResourceService {

    public InputStreamResource getFile(String path) {
        return new InputStreamResource(getClass().getResourceAsStream(path));
    }
}
