package dev.serhat.bookshop.service;


import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.SuccessfulResponse;
import dev.serhat.bookshop.dto.convert.CustomerDtoFactory;
import dev.serhat.bookshop.dto.customers.CreateCustomerRequest;
import dev.serhat.bookshop.dto.customers.UpdateCustomerRequest;
import dev.serhat.bookshop.exception.CustomerAlreadyExistException;
import dev.serhat.bookshop.model.Customer;
import dev.serhat.bookshop.repository.CustomerRepository;
import dev.serhat.bookshop.security.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerService extends BaseService<Customer,Integer>{

    private final PasswordEncoder passwordEncoder;
    private final CustomerDtoFactory customerDtoFactory;
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository repository, PasswordEncoder passwordEncoder, CustomerDtoFactory customerDtoFactory, CustomerRepository customerRepository) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
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

    public Dto getCustomerDtoByEmail(String email){

        return customerDtoFactory.createCustomerDto(getCustomerByEmail(email).get());
    }
/*

 */
    public Dto createCustomer(CreateCustomerRequest createCustomerRequest){



        if(getCustomerByEmail(createCustomerRequest.getEmail()).isPresent())
            throw new CustomerAlreadyExistException();

        boolean isActive= true;
        LocalDateTime lastUpdateDate = LocalDateTime.now();


        Customer customer = new Customer(
                createCustomerRequest.getFirstName(),
                createCustomerRequest.getLastName(),
                createCustomerRequest.getEmail(),
               passwordEncoder.bCryptPasswordEncoder().encode(createCustomerRequest.getPassword()),
                lastUpdateDate,
                lastUpdateDate,
                isActive
        );


        customer = create(customer);

        return customerDtoFactory.createCustomerDto(customer);
    }

    public Dto updateCustomer(UpdateCustomerRequest updateCustomerRequest){

        Customer customer = findById(updateCustomerRequest.getId());

        customer.setEmail(updateCustomerRequest.getEmail());
        customer.setFirstName(updateCustomerRequest.getFirstName());
        customer.setLastName(updateCustomerRequest.getLastName());
        customer.setLastUpdate(LocalDateTime.now());

        customer = update(customer);
        return customerDtoFactory.createCustomerDto(customer);
    }

    public SuccessfulResponse deleteCustomer(int id){

        findById(id); // bu fonksiyon aynı zamanda bu idye ait veri var mı onu kontrol ediyor.
        delete(id);
        return new SuccessfulResponse("Müşteri başarıyla silindi");
    }


}
