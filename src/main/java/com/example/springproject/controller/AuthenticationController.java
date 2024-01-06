package com.example.springproject.controller;

import com.example.springproject.dto.AuthenticationRequest;
import com.example.springproject.dto.AuthenticationResponse;
import com.example.springproject.dto.BaseDTO;
import com.example.springproject.dto.generalResponse.GeneralResponse;
import com.example.springproject.service.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
               .timeStamp(new Date())
               .build();
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GeneralResponse<BaseDTO> authenticationResponse(@RequestBody AuthenticationRequest authenticationRequest){
        return GeneralResponse.builder()
                .data(authenticationService.authenticate(authenticationRequest))
                .message("Login successful!")
                .statusCode(202)
                .timeStamp(new Date())
                .build();
    }


}
