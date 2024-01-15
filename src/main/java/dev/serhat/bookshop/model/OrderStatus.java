package dev.serhat.bookshop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_status")
@Data
public class OrderStatus {

    @Id
    @GeneratedValue
    @Column(name = "status_id")
    private int id;

    private String statusValue;
}
