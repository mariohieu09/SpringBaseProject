package com.example.springproject.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDto extends BaseDTO{

    private String username;
}
