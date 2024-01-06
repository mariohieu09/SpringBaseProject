package com.example.springproject.repository;

import com.example.springproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepo<User> {
    Optional<User> findByUsername(String userName);
}
