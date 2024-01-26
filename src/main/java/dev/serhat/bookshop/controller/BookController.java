package dev.serhat.bookshop.controller;

import dev.serhat.bookshop.dto.book.BookDto;
import dev.serhat.bookshop.service.BookService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> findById(@PathVariable int bookId){
        return ResponseEntity.ok(bookService.findById(bookId));
    }

    @GetMapping("/get-all")
    @Cacheable("books")
    public List<BookDto> findAll(){

        return bookService.findAll();
    }
}
