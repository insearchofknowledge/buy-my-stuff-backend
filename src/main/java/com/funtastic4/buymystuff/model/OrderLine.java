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
    private Integer quantity;
    private Double productPrice;
    @Transient
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name= "orderId")
    private Order order;

    public Double getTotalPrice(){
        return getProduct().getPrice() * getQuantity();
    }
}
