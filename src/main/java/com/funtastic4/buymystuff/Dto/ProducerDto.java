package com.funtastic4.buymystuff.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProducerDto {

    private Long id;
    private String name;

    public ProducerDto() {
    }

    public ProducerDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
