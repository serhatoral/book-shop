package dev.serhat.bookshop.controller;

import dev.serhat.bookshop.dto.book.AuthorDto;
import dev.serhat.bookshop.service.AuthorService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/author")
public class AuthorController {

    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Cacheable(value = "author", key = "#authorId")
    @GetMapping("/{authorId}")
    public AuthorDto findById(@PathVariable int authorId){
        return authorService.findById(authorId) ;
    }


    @PostMapping("/create")
    public AuthorDto create(@RequestBody AuthorDto authorDto){
        return authorService.create(authorDto) ;
    }

  //  @Caching(evict = @CacheEvict(value = "author",allEntries = true,condition = "#authorDto.id != null")) // güncelleme olduğunda cache siliniyor
    @CachePut(value = "author", key = "#authorDto.id") // otomatik güncelliyor.
    @PostMapping("/update")
    public AuthorDto update(@RequestBody AuthorDto authorDto){
        return authorService.update(authorDto) ;
    }
}
