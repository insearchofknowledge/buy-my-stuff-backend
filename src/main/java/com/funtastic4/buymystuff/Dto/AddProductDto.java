package com.funtastic4.buymystuff.Dto;


import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddProductDto {

    private Long id;
    private String name;
    private String description;
    private byte[] imageFile;
    private Double price;
    private Long categoryDto;   // this is only the ID coming from the frontend
    private Long producerDto;   // this is only the ID coming from the frontend
    private int productType;


}
