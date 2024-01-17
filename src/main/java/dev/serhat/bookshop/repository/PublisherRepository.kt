package dev.serhat.bookshop.repository

import dev.serhat.bookshop.model.Publisher
import org.springframework.data.jpa.repository.JpaRepository

interface PublisherRepository  : JpaRepository<Publisher,Int>{
}