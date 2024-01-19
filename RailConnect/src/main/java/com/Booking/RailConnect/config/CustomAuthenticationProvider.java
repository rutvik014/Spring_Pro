package com.Booking.RailConnect.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Implement your authentication logic here
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true; // Assuming you support any type of authentication
    }
}
