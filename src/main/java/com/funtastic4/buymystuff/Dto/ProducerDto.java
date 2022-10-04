package com.funtastic4.buymystuff.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
