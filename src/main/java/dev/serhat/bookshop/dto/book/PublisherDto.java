package dev.serhat.bookshop.dto.book;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublisherDto {

    private int id;

    private String publisherName;
}
