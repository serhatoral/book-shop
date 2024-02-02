package dev.serhat.bookshop.service;

import dev.serhat.bookshop.model.mongodb.LogEntity;
import dev.serhat.bookshop.repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.event.Level;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class LogService {

    private final RabbitTemplate rabbitTemplate;
    private final LogRepository logRepository;

    public LogService(RabbitTemplate rabbitTemplate, LogRepository logRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.logRepository = logRepository;
    }



    @RabbitListener(queues = "log-queue")
    public void logSave(LogEntity logEntity){

        logRepository.save(logEntity);
        System.out.println("Log kaydedildi!");
    }

    public void infoLog(Logger logger,String message){

        LogEntity logEntity = new LogEntity(
                LocalDateTime.now(), Level.INFO.toString(),message, logger.getName() );

        logger.info(message);
        rabbitTemplate.convertAndSend("default","log-routing-key",logEntity);
       // logSave(logEntity);
    }


}
