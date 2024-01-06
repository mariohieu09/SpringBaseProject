package com.example.springproject.service;

import com.example.springproject.dto.RequestUserDto;
import com.example.springproject.dto.ResponseUserDto;
import com.example.springproject.entity.User;

public interface IUserService extends IGeneralService<RequestUserDto, User, ResponseUserDto>{
}
