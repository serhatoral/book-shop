package dev.serhat.bookshop.service;

import dev.serhat.bookshop.dto.book.AuthorDto;
import dev.serhat.bookshop.dto.convert.BookAndRelationsDtoFactory;
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

    public AuthorDto create(AuthorDto authorDto){

        Author author = new Author();
        author.setId(authorDto.getId());
        author.setAuthorName(authorDto.getAuthorName());
     return bookAndRelationsDtoFactory.createAuthorDto(super.create(author)) ;
    }

    public AuthorDto update(AuthorDto authorDto){

        Author author = new Author();
        author.setId(authorDto.getId());
        author.setAuthorName(authorDto.getAuthorName());

        return bookAndRelationsDtoFactory.createAuthorDto(super.update(author));
    }

}
