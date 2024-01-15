package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.*;
import dev.serhat.bookshop.dto.order.OrderDto;
import dev.serhat.bookshop.dto.order.OrderHistoryDto;
import dev.serhat.bookshop.dto.order.OrderLineDto;
import dev.serhat.bookshop.model.Order;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderDtoConverter implements OrderDtoFactory{

    private final OrderLineDtoFactory orderLineDtoFactory;
    private final ShippingMethodDtoFactory shippingMethodDtoFactory;
    private final OrderHistoryDtoFactory orderHistoryDtoFactory;

    public OrderDtoConverter(OrderLineDtoFactory orderLineDtoFactory, ShippingMethodDtoFactory shippingMethodDtoFactory, OrderHistoryDtoFactory orderHistoryDtoFactory) {
        this.orderLineDtoFactory = orderLineDtoFactory;
        this.shippingMethodDtoFactory = shippingMethodDtoFactory;
        this.orderHistoryDtoFactory = orderHistoryDtoFactory;
    }

    @Override
    public Dto createOrderDto(Order order) {
        Set<OrderLineDto> orderLineDtos = new HashSet<>();
        order.getOrderLines().stream().map(orderLine -> orderLineDtos.add((OrderLineDto) orderLineDtoFactory.createOrderLineDto(orderLine))).collect(Collectors.toSet());

        Set<OrderHistoryDto> orderHistoryDtos = new HashSet<>();
        order.getOrderHistories().stream().map(orderHistory -> orderHistoryDtos.add((OrderHistoryDto) orderHistoryDtoFactory.createOrderHistoryDto(orderHistory))).collect(Collectors.toSet());


        return new OrderDto(order.getId(), order.getCreateDate(),order.getLastUpdate(),orderLineDtos,
                (ShippingMethodDto) shippingMethodDtoFactory.createShippingMethodDto(order.getShippingMethod()), orderHistoryDtos);
    }
}
