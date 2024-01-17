package dev.serhat.bookshop.controller

import dev.serhat.bookshop.dto.book.PublisherDto
import dev.serhat.bookshop.service.PublisherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("v1/publisher")
class PublisherController  constructor(private val publisherService: PublisherService){

    @GetMapping("/{publisherId}")
    fun getVehicle(@PathVariable publisherId: Int): PublisherDto {
        return publisherService.getPublisherById(publisherId);
    }

}