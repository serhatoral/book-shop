package dev.serhat.bookshop.repository;

import dev.serhat.bookshop.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
