package com.example.monitorsensors.service.impl;

import com.example.monitorsensors.properties.AuthKeyProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static com.example.monitorsensors.config.SecurityConfig.AUTHORITY_CLAIM_NAME;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final AuthKeyProperties authKeyProperties;
    private final JwtEncoder encoder;

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        String role = authentication.getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority).orElseThrow();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("monitor-sensors-service")
                .issuedAt(now)
                .expiresAt(now.plus(authKeyProperties.getJwtExpirationTime()))
                .subject(authentication.getName())
                .claim(AUTHORITY_CLAIM_NAME, role)
                .build();
        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
