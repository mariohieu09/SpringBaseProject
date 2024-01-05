package com.example.springproject.service;

import com.example.springproject.dto.BaseDTO;
import com.example.springproject.entity.IndexableEntity;
import com.example.springproject.utils.Converter;

import java.util.List;

//D là request dto, E là Entity, R là response dto
public interface IGeneralService<D extends BaseDTO, E extends IndexableEntity, R extends BaseDTO> extends Converter {

    void create(D requestDto);

    R findById(Long id);

    void delete(D requestDto);

    void deleteById(Long id);

    List<R> findAll();
}
