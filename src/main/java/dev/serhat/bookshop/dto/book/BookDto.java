package dev.serhat.bookshop.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class BookDto {


    private int id;


    private String title;

    @JsonProperty("isbn-13")
    private String isbn13;

    @JsonProperty("Number of Pages")
    private int numPages;

    @JsonProperty("Publication Date")
    private LocalDate publicationDate;

    @JsonProperty("Author")
    private Set<AuthorDto> authorDto;

    @JsonProperty("Publisher")
    private PublisherDto publisherDto;
}
