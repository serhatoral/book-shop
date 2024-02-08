package dev.serhat.bookshop.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany
    @JoinColumn(name = "customer_id")
    private Set<Order> orders;

    @ManyToMany
    @JoinTable(
            name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addresses;


    @ManyToMany
    @JoinTable(
            name = "book_like",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> likedBooks;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String password, LocalDateTime createDate,LocalDateTime lastUpdate, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.isActive = isActive;
    }
}


