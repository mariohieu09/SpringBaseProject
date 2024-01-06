package com.example.springproject.controller;

import com.example.springproject.dto.AuthenticationRequest;
import com.example.springproject.dto.AuthenticationResponse;
import com.example.springproject.dto.BaseDTO;
import com.example.springproject.dto.generalResponse.GeneralResponse;
import com.example.springproject.service.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralResponse<BaseDTO> register(@RequestBody AuthenticationRequest authenticationRequest){
       return GeneralResponse.builder()
               .data(authenticationService.register(authenticationRequest))
               .message("Created success!")
               .statusCode(201)
               .build();
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse authenticationResponse(@RequestBody AuthenticationRequest authenticationRequest){
        return authenticationService.authenticate(authenticationRequest);
    }


}
