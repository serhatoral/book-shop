package dev.serhat.bookshop.dto.mapstruct;


import dev.serhat.bookshop.dto.address.AddressDto;
import dev.serhat.bookshop.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE= Mappers.getMapper(AddressMapper.class);


    AddressDto addressToAddressDto(Address address);
}
