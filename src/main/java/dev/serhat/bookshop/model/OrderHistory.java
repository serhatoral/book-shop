package dev.serhat.bookshop.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_history")
@Data
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "history_id")
    private int id;

    private LocalDateTime statusDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus orderStatus;

}
