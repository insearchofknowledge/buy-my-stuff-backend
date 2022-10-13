package com.funtastic4.buymystuff.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orderLines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfProducts;
    private Double productPrice;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
