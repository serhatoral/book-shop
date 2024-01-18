package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.ShippingMethodDto;
import dev.serhat.bookshop.model.ShippingMethod;
import org.springframework.stereotype.Component;

@Component
public class ShippingMethodDtoConverter implements ShippingMethodDtoFactory{
    @Override
    public Dto createShippingMethodDto(ShippingMethod shippingMethod) {
        return new ShippingMethodDto(shippingMethod.getId(), shippingMethod.getMethodName(), shippingMethod.getCost());
    }
}
