package dev.serhat.bookshop.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "order_line")
@Data
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "line_id")
    private int id;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
