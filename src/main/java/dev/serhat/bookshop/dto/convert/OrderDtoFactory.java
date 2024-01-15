package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.model.Order;

public interface OrderDtoFactory {

    public Dto createOrderDto(Order order);
}
