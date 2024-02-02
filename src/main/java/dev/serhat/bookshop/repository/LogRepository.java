package dev.serhat.bookshop.repository;

import dev.serhat.bookshop.model.mongodb.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogEntity,String> {
}
