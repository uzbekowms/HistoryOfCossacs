package ua.history.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.history.dto.AuthDTO;
import ua.history.dto.RegisterDTO;
import ua.history.dto.UserDTO;
import ua.history.service.UserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid AuthDTO authDTO) {
        return ResponseEntity.ok(userService.login(authDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody @Valid RegisterDTO registerDTO) {
        return ResponseEntity.ok(userService.signup(registerDTO));
    }

}
