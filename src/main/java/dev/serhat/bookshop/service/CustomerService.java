package dev.serhat.bookshop.service;


import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.convert.CustomerDtoFactory;
import dev.serhat.bookshop.dto.customers.CreateCustomerRequest;
import dev.serhat.bookshop.exception.CustomerAlreadyExistException;
import dev.serhat.bookshop.model.Customer;
import dev.serhat.bookshop.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerService extends BaseService<Customer,Integer>{

    private final CustomerDtoFactory customerDtoFactory;
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository repository, CustomerDtoFactory customerDtoFactory, CustomerRepository customerRepository) {
        super(repository);
        this.customerDtoFactory = customerDtoFactory;
        this.customerRepository = customerRepository;
    }


    public Dto getCustomerDtoById(int customerId){
        return customerDtoFactory.createCustomerDto(findById(customerId));
    }
   public Dto getCustomerAddressDtoById(int customerId){
        return customerDtoFactory.createCustomerAddressDto(findById(customerId));
   }

   public Dto getCustomerOrderDtoById(int customerId){
        return customerDtoFactory.createCustomerOrderDto(findById(customerId));
   }

    public Dto getCustomerExtendedDtoById(int customerId){
        return customerDtoFactory.createCustomerExtendedDto(findById(customerId));
    }

    public Optional<Customer> getCustomerByEmail(String email){

        return customerRepository.findByEmail(email);
    }


    public Dto createCustomer(CreateCustomerRequest createCustomerRequest){


        if(getCustomerByEmail(createCustomerRequest.getEmail()).isPresent())
            throw new CustomerAlreadyExistException();

        boolean isActive= true;
        LocalDateTime lastUpdateDate = LocalDateTime.now();

        Customer customer = new Customer(
                createCustomerRequest.getFirstName(),
                createCustomerRequest.getLastName(),
                createCustomerRequest.getEmail(),
                createCustomerRequest.getPassword(),
                lastUpdateDate,
                lastUpdateDate,
                isActive
        );


        customer = create(customer);

        return customerDtoFactory.createCustomerDto(customer);
    }

}
