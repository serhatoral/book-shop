package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.order.OrderDto;
import dev.serhat.bookshop.dto.address.AddressDto;
import dev.serhat.bookshop.dto.customers.CustomerAddressDto;
import dev.serhat.bookshop.dto.customers.CustomerDto;
import dev.serhat.bookshop.dto.customers.CustomerOrderDto;
import dev.serhat.bookshop.model.Customer;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter implements CustomerDtoFactory{

    private final AddressDtoConverter addressDtoConverter;
    private final OrderDtoConverter orderDtoConverter;

    public CustomerDtoConverter(AddressDtoConverter addressDtoConverter, OrderDtoConverter orderDtoConverter) {
        this.addressDtoConverter = addressDtoConverter;
        this.orderDtoConverter = orderDtoConverter;
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

        Set<AddressDto> addressDtos = new HashSet<>();
        customer.getAddresses().stream().map(a-> addressDtos.add((AddressDto) addressDtoConverter.createAddressDto(a))).collect(Collectors.toSet());

        return new CustomerAddressDto(
                customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getCreateDate(),
                customer.getLastUpdate(),customer.getIsActive(), addressDtos
        );
    }

    @Override
    public Dto createCustomerOrderDto(Customer customer) {

        Set<OrderDto> orderDtos = new HashSet<>();
        customer.getOrders().stream().map(o-> orderDtos.add((OrderDto) orderDtoConverter.createOrderDto(o))).collect(Collectors.toSet());

        return new CustomerOrderDto(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getCreateDate(),
                customer.getLastUpdate(),customer.getIsActive(),orderDtos);
    }


}
