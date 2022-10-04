package com.funtastic4.buymystuff.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "producers")
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Producer() {
    }

    public Producer(Long id) {
        this.id = id;
    }

    public Producer(Long id, String name) {
        this.id =id;
        this.name = name;
    }

    @OneToMany(mappedBy = "producer")
    private List<Product> productsList;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
