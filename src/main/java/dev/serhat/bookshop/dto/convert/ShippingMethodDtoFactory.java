package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.model.ShippingMethod;

public interface ShippingMethodDtoFactory {

    public Dto createShippingMethodDto(ShippingMethod shippingMethod);
}
