package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.order.OrderLineDto;
import dev.serhat.bookshop.model.OrderLine;
import org.springframework.stereotype.Component;

@Component
public class OrderLineDtoConverter implements OrderLineDtoFactory{
    private final BookAndRelationsDtoFactory bookDtoConverter;

    public OrderLineDtoConverter(BookAndRelationsDtoFactory bookDtoConverter) {
        this.bookDtoConverter = bookDtoConverter;
    }

    @Override
    public Dto createOrderLineDto(OrderLine orderLine) {
        return new OrderLineDto(orderLine.getId(),orderLine.getPrice(),bookDtoConverter.createBookDto(orderLine.getBook()));
    }
}
