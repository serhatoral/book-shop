package dev.serhat.bookshop.service;

import dev.serhat.bookshop.model.mongodb.LogEntity;
import dev.serhat.bookshop.repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void infoLog(Logger logger,String message){

        LogEntity logEntity = new LogEntity(
                LocalDateTime.now(), Level.INFO.toString(),message, logger.getName() );

        logger.info(message);
        logRepository.save(logEntity);
    }
}
