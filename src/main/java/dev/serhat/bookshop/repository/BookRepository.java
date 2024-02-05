package dev.serhat.bookshop.repository;

import dev.serhat.bookshop.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book,Integer> {


     Page<Book> findByTitleContaining(String title, Pageable pageable);

     @Query(value = "SELECT COUNT(*) FROM book b WHERE b.title LIKE %:title%", nativeQuery = true)
     int countByTitleContaining(@Param("title") String title);
}
