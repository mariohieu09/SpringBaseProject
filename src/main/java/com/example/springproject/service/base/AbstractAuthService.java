package com.example.springproject.service.base;

import com.example.springproject.dto.AuthenticationRequest;
import com.example.springproject.dto.AuthenticationResponse;
import com.example.springproject.entity.User;
import com.example.springproject.entity.authentication.CustomUserDetails;
import com.example.springproject.repository.BaseRepo;
import com.example.springproject.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractAuthService extends BaseServiceImpl<AuthenticationRequest, User, AuthenticationResponse>{

    @Autowired
    private JwtService jwtService;
    public AbstractAuthService(BaseRepo<User> repository) {
        super(repository);
    }

    @Override
    public User convertToEntity(AuthenticationRequest requestDto) {
        return User.builder()
                .username(requestDto.getUsername())
                .encode(requestDto.getPassword())
                .build();
    }

    @Override
    public AuthenticationResponse convertToDto(User entity) {
        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(new CustomUserDetails(entity)))
                .build();
    }


}
