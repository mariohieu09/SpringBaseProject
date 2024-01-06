package com.example.springproject.service.base;

import com.example.springproject.dto.RequestUserDto;
import com.example.springproject.dto.ResponseUserDto;
import com.example.springproject.entity.User;
import com.example.springproject.repository.BaseRepo;


public abstract class  AbstractUserService extends BaseServiceImpl<RequestUserDto, User, ResponseUserDto>{

    public AbstractUserService(BaseRepo<User> repository) {
        super(repository);
    }
}
