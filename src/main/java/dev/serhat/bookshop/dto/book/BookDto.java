package dev.serhat.bookshop.dto.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {


    private int id;


    private String title;

    @JsonProperty("isbn-13")
    private String isbn13;

    @JsonProperty("numberOfPages")
    private int numPages;

    @JsonProperty("publicationDate")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date publicationDate;

    @JsonProperty("author")
    private Set<AuthorDto> authorDto;

    @JsonProperty("publisher")
    private PublisherDto publisherDto;
}
