package dev.serhat.bookshop.controller;

import dev.serhat.bookshop.dto.book.BookDto;
import dev.serhat.bookshop.service.BookService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
@CrossOrigin(origins = "http://localhost:9090")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> findById(@PathVariable int bookId){
        return ResponseEntity.ok(bookService.findBookDtoById(bookId));
    }

    @GetMapping("/get-all")
    @Cacheable("books")
    public List<BookDto> findAll(){

        return bookService.findAll();
    }

    @GetMapping("/get-with-page")
    public Page<BookDto> findAllWithPage(@RequestParam int page){

        return bookService.findAllWithPage(page);
    }

    @GetMapping("/get-by-title-containing")
    public Page<BookDto> findByTitleLike(@RequestParam String title, int page){

        return bookService.findByTitleContaining(title,page);
    }
}
