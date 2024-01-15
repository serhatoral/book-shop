package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.order.OrderHistoryDto;
import dev.serhat.bookshop.model.OrderHistory;
import org.springframework.stereotype.Component;

@Component
public class OrderHistoryDtoConverter implements OrderHistoryDtoFactory{
    @Override
    public Dto createOrderHistoryDto(OrderHistory orderHistory) {
        return new OrderHistoryDto(orderHistory.getId(),orderHistory.getStatusDate(),orderHistory.getOrderStatus().getStatusValue());
    }
}
