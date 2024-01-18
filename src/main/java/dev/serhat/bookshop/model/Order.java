package dev.serhat.bookshop.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "cust_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int id;

    private LocalDateTime createDate;

    private LocalDateTime lastUpdate;

    @OneToMany
    @JoinColumn(name = "order_id")
    private Set<OrderLine> orderLines;

    @ManyToOne
    @JoinColumn(name = "shipping_method_id")
    private ShippingMethod shippingMethod;

    @OneToMany
    @JoinColumn(name = "order_id")
    private Set<OrderHistory> orderHistories;

}
