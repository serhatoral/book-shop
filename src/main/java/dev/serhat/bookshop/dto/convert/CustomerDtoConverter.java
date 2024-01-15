package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.customers.CustomerAddressDto;
import dev.serhat.bookshop.dto.customers.CustomerDto;
import dev.serhat.bookshop.model.Customer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter implements CustomerDtoFactory{

    private final AddressDtoConverter addressDtoConverter;

    public CustomerDtoConverter(AddressDtoConverter addressDtoConverter) {
        this.addressDtoConverter = addressDtoConverter;
    }

    @Override
    public Dto createCustomerDto(Customer customer) {

        return new CustomerDto(
                customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getCreateDate(),
                customer.getLastUpdate(),customer.getIsActive()
        );
    }

    @Override
    public Dto createCustomerAddressDto(Customer customer) {

        Set<Dto> addressDtos = new HashSet<>();
        customer.getAddresses().stream().map(a-> addressDtos.add(addressDtoConverter.createAddressDto(a))).collect(Collectors.toSet());

        return new CustomerAddressDto(
                customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getCreateDate(),
                customer.getLastUpdate(),customer.getIsActive(), addressDtos
        );
    }
}
