package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.model.OrderLine;

public interface OrderLineDtoFactory {

    public Dto createOrderLineDto(OrderLine orderLine);
}
