package dev.serhat.bookshop.service;


import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.convert.CustomerDtoFactory;
import dev.serhat.bookshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<Customer,Integer>{

    private final CustomerDtoFactory customerDtoFactory;

    public CustomerService(JpaRepository<Customer, Integer> repository, CustomerDtoFactory customerDtoFactory) {
        super(repository);
        this.customerDtoFactory = customerDtoFactory;
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

}
