package dev.serhat.bookshop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address_status")
@Data
public class AddressStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private int id;

    @Column(name = "address_status")
    private String isActive;
}
