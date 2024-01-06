package com.example.springproject.repository;

import com.example.springproject.entity.IndexableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepo<E extends IndexableEntity> extends JpaRepository<E, Long> {
}
