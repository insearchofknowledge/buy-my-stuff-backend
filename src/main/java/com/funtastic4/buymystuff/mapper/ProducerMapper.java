package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.ProducerDto;
import com.funtastic4.buymystuff.model.Producer;
import org.springframework.stereotype.Service;

@Service
public class ProducerMapper implements Mapper<Producer, ProducerDto> {
    @Override
    public ProducerDto convertToDto(Producer entity) {

        ProducerDto producerDto =new ProducerDto();

        producerDto.setId(entity.getId());
        producerDto.setName(entity.getName());
        return producerDto;
    }

    @Override
    public Producer convertToEntity(ProducerDto dto) {
        Producer producer =new Producer();

        producer.setId(dto.getId());
        producer.setName(dto.getName());
        return producer;
    }
}
