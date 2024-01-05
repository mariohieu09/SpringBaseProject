package com.example.springproject.service.impl;

import com.example.springproject.dto.RequestUserDto;
import com.example.springproject.dto.ResponseUserDto;
import com.example.springproject.entity.User;
import com.example.springproject.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    @Override
    public void create(RequestUserDto requestDto) {

    }

    @Override
    public ResponseUserDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(RequestUserDto requestDto) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<ResponseUserDto> findAll() {
        return null;
    }

    @Override
    public User convertToEntity(RequestUserDto requestDto) {
        return null;
    }

    @Override
    public ResponseUserDto convertToDto(User entity) {
        return null;
    }
}
