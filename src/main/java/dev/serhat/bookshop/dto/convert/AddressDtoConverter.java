package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.Dto;
import dev.serhat.bookshop.dto.address.AddressDto;
import dev.serhat.bookshop.dto.address.CountryDto;
import dev.serhat.bookshop.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoConverter  implements AddressDtoFactory{
    @Override
    public Dto createAddressDto(Address address) {
        return new AddressDto(address.getId(),address.getStreetNumber(),address.getStreetName(),address.getCity(),
                new CountryDto(address.getCountry().getId(),address.getCountry().getCountryName()),address.getStatus().getIsActive());
    }
}
