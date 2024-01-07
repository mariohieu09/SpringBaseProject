package com.example.springproject.dto.generalResponse;

import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListGeneralResponse<T> {

    private int statusCode;


    private List<T> dataList;
    private String message;
    private Date timeStamp = new Date();
}
