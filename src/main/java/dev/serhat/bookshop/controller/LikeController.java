package dev.serhat.bookshop.controller;

import dev.serhat.bookshop.dto.SuccessfulResponse;
import dev.serhat.bookshop.dto.like.LikedBook;
import dev.serhat.bookshop.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/like")
public class LikeController {


    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/book")
    public ResponseEntity<SuccessfulResponse> likeBook(@RequestParam int customerId, int bookId){

        return ResponseEntity.ok(likeService.likeBook(customerId,bookId));
    }

    @GetMapping("/customer-books")
    public ResponseEntity<LikedBook> getLikeBook(@RequestParam int customerId){

        return ResponseEntity.ok(likeService.getLikedBooks(customerId));
    }
}
