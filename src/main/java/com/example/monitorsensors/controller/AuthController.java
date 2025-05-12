package com.example.monitorsensors.controller;

import com.example.monitorsensors.dto.auth.AuthRequestDto;
import com.example.monitorsensors.dto.auth.AuthResponseDto;
import com.example.monitorsensors.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication management APIs")
public class AuthController {

    private final AuthService authService;

    @Operation(
        summary = "Login to get JWT token",
        description = "Authenticates user and returns JWT token. The token should be included in the Authorization header for subsequent requests."
    )
    @PostMapping("/login")
    public AuthResponseDto login(@Valid @RequestBody AuthRequestDto request) {
        return authService.authenticate(request);
    }
}
