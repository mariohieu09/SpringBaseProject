package com.example.springproject.controller;

import com.example.springproject.dto.RequestUserDto;
import com.example.springproject.dto.ResponseUserDto;
import com.example.springproject.dto.generalResponse.GeneralResponse;
import com.example.springproject.dto.generalResponse.ListGeneralResponse;
import com.example.springproject.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListGeneralResponse<ResponseUserDto> getAllUser(){
        return ListGeneralResponse.<ResponseUserDto>builder()
                .statusCode(200)
                .dataList(userService.findAll())
                .message("All user")
                .timeStamp(new Date())
                .build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralResponse<ResponseUserDto> createUser(@RequestBody RequestUserDto requestUserDto){
        userService.createUser(requestUserDto);
        return GeneralResponse.<ResponseUserDto>builder()
                .data(userService.convertToDto(userService.convertToEntity(requestUserDto)))
                .message("Created success!")
                .timeStamp(new Date())
                .statusCode(200)
                .build();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<ResponseUserDto> getUserById(@PathVariable Long id){
        return GeneralResponse.<ResponseUserDto>builder()
                .data(userService.findById(id))
                .statusCode(200)
                .message("User")
                .timeStamp(new Date())
                .build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUserById(@PathVariable Long id){
        userService.deleteById(id);
        return "Delete user success!";
    }

}

