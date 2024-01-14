package dev.serhat.bookshop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "publisher")
@Data
public class Publisher {

    @Id
    @GeneratedValue
    @Column(name = "publisher_id")
    private int id;

    private String publisherName;

}
