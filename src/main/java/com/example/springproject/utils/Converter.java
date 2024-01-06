package com.example.springproject.utils;

//D là request dto, E là Entity, R là response dto
public abstract class Converter<D, E, R> {
    // Hàm convert từ dto request sang entity
   public abstract E convertToEntity(D requestDto);

    // Hàm convert từ Entity sang response dto
    public abstract R convertToDto(E entity);
}
