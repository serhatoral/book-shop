package dev.serhat.bookshop.dto.order;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.ShippingMethodDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
public class OrderDto implements Dto {

    private int id;

    private LocalDateTime createDate;

    private LocalDateTime lastUpdate;

    private Set<OrderLineDto>  orderLineDtos;

    private ShippingMethodDto shippingMethodDto;

    private Set<OrderHistoryDto> orderHistoryDtos;
}
