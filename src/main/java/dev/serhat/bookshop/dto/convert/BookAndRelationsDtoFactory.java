package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.AuthorDto;
import dev.serhat.bookshop.dto.BookDto;
import dev.serhat.bookshop.dto.PublisherDto;
import dev.serhat.bookshop.model.Author;
import dev.serhat.bookshop.model.Book;
import dev.serhat.bookshop.model.Publisher;


public interface BookAndRelationsDtoFactory extends DtoFactory{

    public BookDto createBookDto(Book book);
    public AuthorDto createAuthorDto(Author author);

    public PublisherDto createPublisherDto(Publisher publisher);
}
