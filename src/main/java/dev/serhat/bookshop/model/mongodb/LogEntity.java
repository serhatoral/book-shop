package dev.serhat.bookshop.model.mongodb;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collation = "logs")
@Getter
@Setter
public class LogEntity {

    @Id
    @GeneratedValue
    private String id;
    private LocalDateTime logDate;
    private String level;
    private String message;
    private String logLocation;


    public LogEntity(LocalDateTime logDate, String level, String message, String logLocation) {
        this.logDate = logDate;
        this.level = level;
        this.message = message;
        this.logLocation = logLocation;
    }
}
