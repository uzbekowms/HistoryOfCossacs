package ua.history.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.history.service.ResourceService;


@RestController
@RequestMapping(value = "/files")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping(value = "/images/{name}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable String name) {
        return ResponseEntity.ok(resourceService.getFile(name, "/files/"));
    }

    @PostMapping("/images")
    public ResponseEntity<String> writeImage(@RequestBody MultipartFile file) {
        return ResponseEntity.ok(resourceService.writeFile(file));
    }

}
