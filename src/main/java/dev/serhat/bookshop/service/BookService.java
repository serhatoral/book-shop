package dev.serhat.bookshop.service;

import dev.serhat.bookshop.dto.BookDto;
import dev.serhat.bookshop.dto.convert.BookAndRelationsDtoFactory;
import dev.serhat.bookshop.exception.DataNotFoundException;
import dev.serhat.bookshop.model.Book;
import dev.serhat.bookshop.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookAndRelationsDtoFactory bookAndRelationsDtoFactory;

    public BookService(BookRepository bookRepository, BookAndRelationsDtoFactory bookAndRelationsDtoFactory) {
        this.bookRepository = bookRepository;
        this.bookAndRelationsDtoFactory = bookAndRelationsDtoFactory;
    }

    public BookDto findById(int id){

       // return bookRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Şu id'ye sahip kitap bulunamadı: "+id ));
        return bookAndRelationsDtoFactory.createBookDto(bookRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Şu id'ye sahip kitap bulunamadı: "+id )));
    }
}
