package dev.serhat.bookshop.model;


import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "book")
@Data
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;

    private String title;

    private String isbn13;

    private int numPages;

    private Date publicationDate;

    @ManyToOne //Unidirectional
    @JoinColumn(name = "language_id")
    private BookLanguage language;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;


}


