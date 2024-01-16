package dev.serhat.bookshop.service;


import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.convert.CustomerDtoFactory;
import dev.serhat.bookshop.dto.mapstruct.CustomerMapper;
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
       // return customerDtoFactory.createCustomerDto(findById(customerId));
        return CustomerMapper.INSTANCE.customerToCustomerDto(findById(customerId));
    }
   public Dto getCustomerAddressDtoById(int customerId){
       // return customerDtoFactory.createCustomerAddressDto(findById(customerId));
       return CustomerMapper.INSTANCE.customerToCustomerAddressDto(findById(customerId));
   }

   public Dto getCustomerOrderDtoById(int customerId){
       // return customerDtoFactory.createCustomerOrderDto(findById(customerId));
       return CustomerMapper.INSTANCE.customerToCustomerOrderDto(findById(customerId));
   }

    public Dto getCustomerExtendedDtoById(int customerId){
       // return customerDtoFactory.createCustomerExtendedDto(findById(customerId));
        return CustomerMapper.INSTANCE.customerToCustomerExtendedDto(findById(customerId));
    }

}
