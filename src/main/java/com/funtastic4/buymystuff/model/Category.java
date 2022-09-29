package com.funtastic4.buymystuff.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="categories")
@Getter
@Setter
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;


    public Category() {
    }

    public Category(String name) {
        this.id = id;
        this.name = name;
    }
}
