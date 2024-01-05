package com.example.springproject.service.impl;

import com.example.springproject.dto.RequestUserDto;
import com.example.springproject.dto.ResponseUserDto;
import com.example.springproject.entity.User;
import com.example.springproject.repository.UserRepository;
import com.example.springproject.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public void create(RequestUserDto requestDto) {
        User user = this.convertToEntity(requestDto);
        user.setEncode(passwordEncoder.encode(user.getEncode()));
        userRepository.save(user);
    }

    @Override
    public ResponseUserDto findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new IllegalArgumentException("Can't find the user!");
        }
        return this.convertToDto(userOptional.get());
    }

    @Override
    public void delete(RequestUserDto requestDto) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<ResponseUserDto> findAll() {
        return userRepository.findAll().stream()
                .map(this::convertToDto)
                .toList();
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
