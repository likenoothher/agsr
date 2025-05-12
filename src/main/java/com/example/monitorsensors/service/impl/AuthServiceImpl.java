package com.example.monitorsensors.service.impl;

import com.example.monitorsensors.dto.auth.AuthRequestDto;
import com.example.monitorsensors.dto.auth.AuthResponseDto;
import com.example.monitorsensors.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthResponseDto authenticate(AuthRequestDto request) {
        var token = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        String jwtToken = jwtService.generateToken(authentication);
        return new AuthResponseDto(jwtToken);
    }
}
