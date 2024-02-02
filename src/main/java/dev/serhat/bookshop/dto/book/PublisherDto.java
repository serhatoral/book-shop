package dev.serhat.bookshop.dto.book;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDto {

    private int id;

    private String publisherName;
}
