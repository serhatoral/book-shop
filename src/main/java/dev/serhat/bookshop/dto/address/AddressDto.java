package dev.serhat.bookshop.dto.address;

import dev.serhat.bookshop.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDto implements Dto {

    private int id;

    private String streetNumber;

    private String streetName;

    private String city;

    private CountryDto countryDto;

    private String isActive;


}
