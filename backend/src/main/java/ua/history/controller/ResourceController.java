package ua.history.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.history.service.ResourceService;

import java.io.File;
import java.io.FileNotFoundException;


@RestController
@RequestMapping(value = "/files")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping(value = "/{name:.+}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Resource> getImage(@PathVariable String name) throws FileNotFoundException {
        return ResponseEntity.ok(resourceService.getFile(name));
    }

    @PostMapping
    public ResponseEntity<String> writeImage(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(resourceService.writeFile(file));
    }
}
