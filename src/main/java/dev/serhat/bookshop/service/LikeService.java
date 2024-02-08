package dev.serhat.bookshop.service;

import dev.serhat.bookshop.dto.SuccessfulResponse;
import dev.serhat.bookshop.model.Book;
import dev.serhat.bookshop.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final CustomerService customerService;
    private final BookService bookService;


    public LikeService(CustomerService customerService, BookService bookService) {
        this.customerService = customerService;
        this.bookService = bookService;
    }


    public SuccessfulResponse likeBook(int customerId, int bookId){

        Customer customer = customerService.findById(customerId);
        Book book = bookService.findById(bookId);

        customer.getLikedBooks().add(book);

        customerService.update(customer);
        return  new SuccessfulResponse("Kitap beğinilenler listesine alındı");
    }
}
