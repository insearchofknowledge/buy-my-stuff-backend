package com.funtastic4.buymystuff.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="producers")
@Getter
@Setter
@ToString
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Producer() {
    }

    public Producer(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "producer")
    private List<Product> productsList;

}
