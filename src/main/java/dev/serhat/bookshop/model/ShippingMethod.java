package dev.serhat.bookshop.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "shipping_method")
@Data
public class ShippingMethod {

    @Id
    @GeneratedValue
    @Column(name = "method_id")
    private int id;

    private String methodName;


    private BigDecimal cost;

    @OneToMany(mappedBy = "shippingMethod")
    private Set<Order> orders;
}
