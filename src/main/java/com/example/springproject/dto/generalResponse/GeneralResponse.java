package com.example.springproject.dto.generalResponse;

import com.example.springproject.dto.BaseDTO;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse<T extends BaseDTO> {
    private int statusCode;


    private T data;
    private String message;
    private Date timeStamp = new Date();

}
