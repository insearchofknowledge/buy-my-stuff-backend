package com.funtastic4.buymystuff.mapper;

public interface Mapper <E, D>{

    public D convertToDto(E entity);
    public E convertToEntity(D dto);

}
