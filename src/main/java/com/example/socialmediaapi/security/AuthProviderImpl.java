package com.example.socialmediaapi.security;

import com.example.socialmediaapi.services.UserDetailsServiceImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

public class AuthProviderImpl implements AuthenticationProvider {

    private final UserDetailsServiceImpl personDetailsService;


    public AuthProviderImpl(UserDetailsServiceImpl personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails personDetails = personDetailsService.loadUserByUsername(username);

        String password = authentication.getCredentials().toString();

        if (!password.equals(personDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }
        return new UsernamePasswordAuthenticationToken(personDetails, password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
