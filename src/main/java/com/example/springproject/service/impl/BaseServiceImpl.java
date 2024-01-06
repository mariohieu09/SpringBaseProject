package com.example.springproject.service.impl;

import com.example.springproject.dto.BaseDTO;
import com.example.springproject.entity.IndexableEntity;
import com.example.springproject.repository.BaseRepo;
import com.example.springproject.service.IGeneralService;
import com.example.springproject.utils.Converter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<D extends BaseDTO, E extends IndexableEntity, R extends BaseDTO> extends Converter<D, E , R> implements IGeneralService<D, E , R> {

    private final BaseRepo<E> repository;
    @Override
    public void create(D requestDto) {
        repository.save(this.convertToEntity(requestDto));
    }

    @Override
    public R findById(Long id) {
        Optional<E> optionalEntity = repository.findById(id);
        if(optionalEntity.isEmpty()){
            throw new IllegalArgumentException("Id doesn't exist!");
        }
        return this.convertToDto(optionalEntity.get());
    }

    @Override
    public void delete(D requestDto) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<R> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDto).toList();
    }


}
