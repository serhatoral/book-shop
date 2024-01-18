package dev.serhat.bookshop.dto.customers;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.address.AddressDto;
import dev.serhat.bookshop.dto.order.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
public class CustomerExtendedDto implements Dto {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDateTime createDate;

    private LocalDateTime lastUpdate;

    private Boolean isActive;

    private Set<OrderDto> orders;

    private Set<AddressDto> addresses;
}
