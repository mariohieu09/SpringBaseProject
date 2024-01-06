package com.example.springproject.dto;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDto extends BaseDTO{

    private String username;
    private String encodeString;
}
