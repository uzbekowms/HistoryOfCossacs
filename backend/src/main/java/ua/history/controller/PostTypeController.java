package ua.history.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.history.model.PostType;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/post_types")
public class PostTypeController {

    @GetMapping
    public ResponseEntity<List<String>> getPostTypes() {
        return ResponseEntity.ok(Arrays.stream(PostType.class.getEnumConstants()).map(PostType::getName).toList());
    }
}
