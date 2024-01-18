package dev.serhat.bookshop.dto.customers;

import dev.serhat.bookshop.dto.order.OrderDto;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class CustomerOrderDto extends CustomerDto{

    private Set<OrderDto> orderDtos;
    public CustomerOrderDto(int id, String firstName, String lastName, String email, LocalDateTime createDate, LocalDateTime lastUpdate, Boolean isActive,Set<OrderDto> orderDtos) {
        super(id, firstName, lastName, email, createDate, lastUpdate, isActive);
        this.orderDtos = orderDtos;
    }


}
