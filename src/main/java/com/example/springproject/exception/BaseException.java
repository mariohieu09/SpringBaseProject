package com.example.springproject.exception;

import lombok.*;

import java.util.Map;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseException extends Exception{

    private Map<String, String> params;


}
