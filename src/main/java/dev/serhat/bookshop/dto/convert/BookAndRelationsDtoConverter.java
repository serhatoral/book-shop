package dev.serhat.bookshop.dto.convert;

import dev.serhat.bookshop.dto.AuthorDto;
import dev.serhat.bookshop.dto.BookDto;
import dev.serhat.bookshop.dto.PublisherDto;
import dev.serhat.bookshop.model.Author;
import dev.serhat.bookshop.model.Book;
import dev.serhat.bookshop.model.Publisher;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookAndRelationsDtoConverter implements BookAndRelationsDtoFactory{
    @Override
    public BookDto createBookDto(Book book) {


        Set<AuthorDto> authorDtos = new HashSet<>();
        book.getAuthors().stream().map(author -> authorDtos.add(createAuthorDto(author))).collect(Collectors.toSet());

        return Optional.of(book).map(b -> new BookDto(
                b.getId(),b.getTitle(),b.getIsbn13(),b.getNumPages(),b.getPublicationDate(),
                authorDtos,createPublisherDto(b.getPublisher()))).orElse(null);
    }

    @Override
    public AuthorDto createAuthorDto(Author author) {

        return new AuthorDto(author.getId(),author.getAuthorName());
    }

    @Override
    public PublisherDto createPublisherDto(Publisher publisher) {
        return new PublisherDto(publisher.getId(), publisher.getPublisherName());
    }
}
