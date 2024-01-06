package com.example.springproject.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest extends BaseDTO{

    private String username;
    private String password;
}
