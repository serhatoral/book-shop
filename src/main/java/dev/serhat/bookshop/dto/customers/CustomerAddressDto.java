package dev.serhat.bookshop.dto.customers;

import dev.serhat.bookshop.dto.Dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class CustomerAddressDto extends CustomerDto implements Dto {

    private Set<Dto> addresses;


    public CustomerAddressDto(int id, String firstName, String lastName, String email, LocalDateTime createDate, LocalDateTime lastUpdate, Boolean isActive, Set<Dto> addresses) {
        super(id, firstName, lastName, email, createDate, lastUpdate, isActive);
        this.addresses = addresses;
    }
}
