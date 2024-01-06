package com.example.springproject.service.impl;

import com.example.springproject.dto.RequestUserDto;
import com.example.springproject.dto.ResponseUserDto;
import com.example.springproject.entity.User;
import com.example.springproject.repository.BaseRepo;
import com.example.springproject.repository.UserRepository;
import com.example.springproject.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service

public class UserService extends BaseServiceImpl<RequestUserDto, User, ResponseUserDto>{
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserService(BaseRepo<User> repository) {
        super(repository);
    }


    public void createUser(RequestUserDto userDto){
        userDto.setEncodeString(passwordEncoder.encode(userDto.getEncodeString()));
        create(userDto);
    }
    @Override
    public User convertToEntity(RequestUserDto requestDto) {
        return User.builder()
                .username(requestDto.getUsername())
                .encode(requestDto.getEncodeString())
                .build();
    }

    @Override
    public ResponseUserDto convertToDto(User entity) {
        return ResponseUserDto.builder()
                .username(entity.getUsername())
                .build();
    }
}
