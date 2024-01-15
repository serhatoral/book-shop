package dev.serhat.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ShippingMethodDto implements Dto{
    private int id;

    private String methodName;


    private BigDecimal cost;
}
