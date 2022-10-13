package com.funtastic4.buymystuff.model;

import com.funtastic4.buymystuff.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name ="products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    //@Enumerated(EnumType.STRING)
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name="producerId")
    private Producer producer;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;

    @OneToMany(mappedBy ="product")
    private List<OrderLine> orderLines;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", productType=" + productType +
                '}';
    }
}
