package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.Dto.ProducerDto;
import com.funtastic4.buymystuff.mapper.ProducerMapper;
import com.funtastic4.buymystuff.model.Producer;
import com.funtastic4.buymystuff.repository.ProducerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProducerService {

    private final ProducerRepository producerRepository;
    private final ProducerMapper producerMapper;

    public ProducerService(ProducerRepository producerRepository, ProducerMapper producerMapper) {
        this.producerRepository = producerRepository;
        this.producerMapper = producerMapper;
    }

    public ProducerDto createProducer(ProducerDto producerDto) {
        Producer producer = producerMapper.convertToEntity(producerDto);
        producerRepository.save(producer);
        return producerMapper.convertToDto(producer);
    }
    private Producer getProducer(long id) {
        Producer producer =producerRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format("Producer with id %s doesn't exist", id)));
        return producer;
    }
    public ProducerDto findProducerById(long id) {
        Producer producer = getProducer(id);
        return producerMapper.convertToDto(producer);
    }

    public List<ProducerDto> findAllProducers() {
        return producerRepository.findAll().stream().map(producerMapper::convertToDto).collect(Collectors.toList());
    }

    public ProducerDto updateProducer(Long id, ProducerDto producerDto) {
        Producer producer = getProducer(id);
        producer.setName(producerDto.getName());
        producerRepository.save(producer);
        return producerMapper.convertToDto(producer);
    }

    public void deleteProducer(Long id) {
        getProducer(id);
        producerRepository.deleteById(id);
    }
}
