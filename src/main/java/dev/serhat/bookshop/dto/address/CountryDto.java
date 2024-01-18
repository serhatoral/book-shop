package dev.serhat.bookshop.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryDto {

    private int id;

    private String countryName;
}
