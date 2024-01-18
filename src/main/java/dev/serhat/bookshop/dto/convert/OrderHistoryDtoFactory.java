package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.model.OrderHistory;

public interface OrderHistoryDtoFactory {

    public Dto createOrderHistoryDto(OrderHistory orderHistory);
}
