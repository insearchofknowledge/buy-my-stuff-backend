package com.funtastic4.buymystuff.model;

import com.funtastic4.buymystuff.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDateTime orderDate;
    private String deliveryAddress;
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AppUser user;

    private Double totalCost;

    public Double calculateTotalCost() {
        double sum = 0;
        for (OrderLine line : orderLines) {
            sum += line.getTotalPrice();
        }
        System.out.println("Calculated sum: "+sum);
        return sum;
    }
}
