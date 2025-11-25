package dev.kuchishkin.security.jwt;

import dev.kuchishkin.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationService {
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("Not authenticated");
        }

        return (User) authentication.getPrincipal();
    }
}
