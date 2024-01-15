package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.model.Customer;

public interface CustomerDtoFactory{

    public Dto createCustomerDto(Customer customer);
    public Dto createCustomerAddressDto(Customer customer);

    public Dto createCustomerOrderDto(Customer customer);

    public Dto createCustomerExtendedDto(Customer customer);

}
