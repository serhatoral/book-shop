package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.model.Address;

public interface AddressDtoFactory {

   public Dto createAddressDto(Address address);
}
