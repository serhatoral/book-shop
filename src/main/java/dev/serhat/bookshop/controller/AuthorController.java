package dev.serhat.bookshop.controller;

import dev.serhat.bookshop.dto.book.AuthorDto;
import dev.serhat.bookshop.model.Author;
import dev.serhat.bookshop.service.AuthorService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/author")
public class AuthorController {

    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{authorId}")
    public AuthorDto findById(@PathVariable int authorId){
        return authorService.findById(authorId) ;
    }
}
