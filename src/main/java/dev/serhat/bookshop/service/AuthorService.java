package dev.serhat.bookshop.service;

import dev.serhat.bookshop.dto.AuthorDto;
import dev.serhat.bookshop.dto.convert.BookAndRelationsDtoFactory;
import dev.serhat.bookshop.exception.DataNotFoundException;
import dev.serhat.bookshop.model.Author;
import dev.serhat.bookshop.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends BaseService<Author,Integer> {

    private final AuthorRepository authorRepository;
    private final BookAndRelationsDtoFactory bookAndRelationsDtoFactory;

    public AuthorService(AuthorRepository authorRepository, BookAndRelationsDtoFactory bookAndRelationsDtoFactory) {

        super(authorRepository);
        this.authorRepository = authorRepository;
        this.bookAndRelationsDtoFactory = bookAndRelationsDtoFactory;
    }


    public AuthorDto findById(int id){

        // Burada Author BaseService'de bulunan methodla getirilmiştir. Burada sadece dto çevrimi yapılmaktadır.
        // Bu sayede daha odaklı olmuş ve satır kısalmıştır.
        return bookAndRelationsDtoFactory.createAuthorDto(super.findById(id));
      //  return bookAndRelationsDtoFactory.createAuthorDto(authorRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Şu id'ye sahip kitap bulunamadı: "+id )));
    }
}
