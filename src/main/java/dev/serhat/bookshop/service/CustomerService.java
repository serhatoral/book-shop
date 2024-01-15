package dev.serhat.bookshop.service;

import dev.serhat.bookshop.model.Customer;
import dev.serhat.bookshop.repository.CustomerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<Customer,Integer>{


    protected CustomerService(JpaRepository<Customer, Integer> repository) {
        super(repository);
    }


}
