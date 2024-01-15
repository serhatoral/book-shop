package dev.serhat.bookshop.repository;

import dev.serhat.bookshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
