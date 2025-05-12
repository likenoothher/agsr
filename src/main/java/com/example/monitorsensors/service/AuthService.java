package com.example.monitorsensors.service;

import com.example.monitorsensors.dto.auth.AuthRequestDto;
import com.example.monitorsensors.dto.auth.AuthResponseDto;

public interface AuthService {

    AuthResponseDto authenticate(AuthRequestDto request);
}
