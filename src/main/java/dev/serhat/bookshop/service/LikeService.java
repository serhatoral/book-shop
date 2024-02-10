package dev.serhat.bookshop.service;

import dev.serhat.bookshop.dto.SuccessfulResponse;
import dev.serhat.bookshop.dto.book.BookDto;
import dev.serhat.bookshop.dto.convert.BookAndRelationsDtoFactory;
import dev.serhat.bookshop.dto.like.LikedBook;
import dev.serhat.bookshop.model.Book;
import dev.serhat.bookshop.model.Customer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class LikeService {

    private final CustomerService customerService;
    private final BookService bookService;
    private final BookAndRelationsDtoFactory bookAndRelationsDtoFactory;
    private final KafkaTemplate<String,Object> kafkaTemplate;


    public LikeService(CustomerService customerService, BookService bookService, BookAndRelationsDtoFactory bookAndRelationsDtoFactory, KafkaTemplate<String, Object> kafkaTemplate) {
        this.customerService = customerService;
        this.bookService = bookService;
        this.bookAndRelationsDtoFactory = bookAndRelationsDtoFactory;
        this.kafkaTemplate = kafkaTemplate;
    }


    public SuccessfulResponse likeBook(int customerId, int bookId){

        Customer customer = customerService.findById(customerId);
        Book book = bookService.findById(bookId);

        customer.getLikedBooks().add(book);

        kafkaTemplate.send("customer-like-book",customer);
        return  new SuccessfulResponse("Kitap beğinilenler listesine alındı");
    }

    @KafkaListener(topics = "customer-like-book", groupId = "group-id")
    public void saveLikedBook(Customer customer){
        customerService.update(customer);
    }

    public LikedBook getLikedBooks(int customerId){
        LikedBook like = new LikedBook();
        like.setCustomerId(customerId);

        Set<BookDto> likedBooks = new HashSet<>();

        customerService.findById(customerId).getLikedBooks().forEach(book ->
                likedBooks.add(bookAndRelationsDtoFactory.createBookDto(book)));

        like.setLikedBooks(likedBooks);


        return like;
    }
}
