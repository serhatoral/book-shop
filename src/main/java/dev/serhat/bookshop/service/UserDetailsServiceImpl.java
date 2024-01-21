package dev.serhat.bookshop.service;

import dev.serhat.bookshop.exception.DataNotFoundException;
import dev.serhat.bookshop.model.Customer;
import dev.serhat.bookshop.repository.CustomerRepository;
import dev.serhat.bookshop.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private  final CustomerRepository customerRepository;

    public UserDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByEmail(email);

        return customer.map(SecurityUser::new).orElseThrow(()->new DataNotFoundException(email+ "  ait bir kullanıcı bulunamadı"));
    }
}
