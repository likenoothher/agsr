package com.example.monitorsensors.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.time.Duration;

@Data
@ConfigurationProperties("auth")
public class AuthKeyProperties {

    private Resource keyStore;
    private String keyPassword;
    private String storePassword;
    private String alias;
    private KeyPair keyPair;
    private Duration jwtExpirationTime;

    public KeyPair getKeyPair() {
        if (keyPair == null) {
            try {
                KeyStore keystore = KeyStore.getInstance("JKS");
                keystore.load(keyStore.getInputStream(), storePassword.toCharArray());
                PrivateKey key = (PrivateKey) keystore.getKey(alias, keyPassword.toCharArray());
                Certificate cert = keystore.getCertificate(alias);
                PublicKey publicKey = cert.getPublicKey();
                keyPair = new KeyPair(publicKey, key);
            } catch (Exception e) {
                throw new RuntimeException("Failed to load key pair from keystore", e);
            }
        }
        return keyPair;
    }
}
