package com.crudVueDB.crudVue.services.mappers;

public interface CustomMapper<DTO, T> {
    DTO toDto(T entity);

    T toEntity(DTO dto);

}
