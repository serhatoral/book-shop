package dev.serhat.bookshop.service

import dev.serhat.bookshop.dto.book.PublisherDto
import dev.serhat.bookshop.dto.convert.BookAndRelationsDtoFactory
import dev.serhat.bookshop.model.Publisher
import dev.serhat.bookshop.repository.PublisherRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class PublisherService constructor(repository: JpaRepository<Publisher, Int>?,
                                   private val publisherDtoConverter: BookAndRelationsDtoFactory)
    : BaseService<Publisher, Int>(repository) {

     fun getPublisherById(id: Int) : PublisherDto{
        return publisherDtoConverter.createPublisherDto(super.findById(id));
    }
}