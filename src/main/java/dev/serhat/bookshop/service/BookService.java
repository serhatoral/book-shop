package dev.serhat.bookshop.service;

import dev.serhat.bookshop.dto.book.BookDto;
import dev.serhat.bookshop.dto.convert.BookAndRelationsDtoFactory;
import dev.serhat.bookshop.model.Book;
import dev.serhat.bookshop.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService extends BaseService<Book,Integer>{
    private final BookRepository bookRepository;
    private final BookAndRelationsDtoFactory bookAndRelationsDtoFactory;

    public BookService(BookRepository bookRepository, BookAndRelationsDtoFactory bookAndRelationsDtoFactory) {
        super(bookRepository);
        this.bookRepository = bookRepository;
        this.bookAndRelationsDtoFactory = bookAndRelationsDtoFactory;
    }

    public BookDto findById(int id){


      //  return bookAndRelationsDtoFactory.createBookDto(bookRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Şu id'ye sahip kitap bulunamadı: "+id )));
          return  bookAndRelationsDtoFactory.createBookDto(super.findById(id));
    }

    public List<BookDto> findAll(){
        List<BookDto> bookDtos = new ArrayList<>();

        List<Book> books = bookRepository.findAll();
        books.forEach(b -> bookDtos.add(bookAndRelationsDtoFactory.createBookDto(b)));
        return  bookDtos;
    }
}
