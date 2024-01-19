package com.Booking.RailConnect.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class JwtTokenProvider {

    // Replace this with a more secure mechanism, e.g., use application properties
    public static final String SECRET_KEY = "yourSecretKeyHere";

    private final Key secretKey;

    // Constructor
    public JwtTokenProvider() {
        byte[] decodedSecretKey = Base64.getDecoder().decode(SECRET_KEY);
        this.secretKey = new SecretKeySpec(decodedSecretKey, SignatureAlgorithm.HS512.getJcaName());
    }

    // Other methods

    public String generateToken(String username) {
        // Your token generation logic using SignatureAlgorithm
        String token = Jwts.builder()
            .setSubject(username)
            .signWith(secretKey)
            .compact();
        return token;
    }

    // Other methods
}
