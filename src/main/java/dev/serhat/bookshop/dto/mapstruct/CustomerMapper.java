package dev.serhat.bookshop.dto.mapstruct;

import dev.serhat.bookshop.dto.customers.CustomerAddressDto;
import dev.serhat.bookshop.dto.customers.CustomerDto;
import dev.serhat.bookshop.dto.customers.CustomerExtendedDto;
import dev.serhat.bookshop.dto.customers.CustomerOrderDto;
import dev.serhat.bookshop.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    CustomerDto customerToCustomerDto(Customer customer);


    CustomerAddressDto customerToCustomerAddressDto(Customer customer);

    CustomerOrderDto customerToCustomerOrderDto(Customer customer);

    CustomerExtendedDto customerToCustomerExtendedDto(Customer customer);
}
