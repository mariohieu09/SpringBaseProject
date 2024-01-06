package com.example.springproject.service.impl;

import com.example.springproject.dto.AuthenticationRequest;
import com.example.springproject.dto.AuthenticationResponse;
import com.example.springproject.entity.User;
import com.example.springproject.repository.BaseRepo;
import com.example.springproject.service.JwtService;
import com.example.springproject.service.base.AbstractAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService extends AbstractAuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationService(BaseRepo<User> repository) {
        super(repository);
    }

    public AuthenticationResponse register(AuthenticationRequest request){
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        create(request);
        return convertToDto(convertToEntity(request));
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        return convertToDto(convertToEntity(request));
    }
}
