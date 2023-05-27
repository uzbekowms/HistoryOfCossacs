package ua.history.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.history.model.PostType;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/post_types")
public class PostTypeController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getPostTypes() {
        return ResponseEntity.ok(Arrays.stream(PostType.values()).collect(Collectors.toMap(PostType::name, PostType::getName)));
    }
}
