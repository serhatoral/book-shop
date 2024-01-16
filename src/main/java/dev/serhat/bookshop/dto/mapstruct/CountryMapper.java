package dev.serhat.bookshop.dto.mapstruct;

import dev.serhat.bookshop.dto.address.CountryDto;
import dev.serhat.bookshop.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper( CountryMapper.class );

    CountryDto countryToCountryDto(Country country);
}
