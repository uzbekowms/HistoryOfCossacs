package ua.history.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.history.service.ResourceService;

import java.io.InputStream;

@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping(value = "/{path}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable String path) {
        return ResponseEntity.ok(resourceService.getFile(path));
    }
}
