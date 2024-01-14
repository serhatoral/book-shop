package dev.serhat.bookshop.service;

import dev.serhat.bookshop.exception.DataNotFoundException;
import dev.serhat.bookshop.model.Book;
import dev.serhat.bookshop.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(int id){

        return bookRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Şu id'ye sahip kitap bulunamadı: "+id ));
    }
}
