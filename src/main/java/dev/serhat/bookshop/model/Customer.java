package dev.serhat.bookshop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int id;

    private String firstName;
    private String lastName;

    private String email;

    private String password;

    private LocalDateTime createDate;

    private LocalDateTime lastUpdate;

    @Column(name = "active")
    private Boolean isActive;


}
