package dev.serhat.bookshop.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "author")
@Data
public class Author {

    @Id
    @GeneratedValue
    @Column(name = "author_id")
    private int id;


    private String authorName;

   /* @ManyToMany
    private Set<Book> books;*/


}
