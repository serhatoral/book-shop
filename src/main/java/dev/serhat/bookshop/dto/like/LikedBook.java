package dev.serhat.bookshop.dto.like;

import dev.serhat.bookshop.dto.book.BookDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class LikedBook {

    private int customerId;

    private Set<BookDto> likedBooks;
}
