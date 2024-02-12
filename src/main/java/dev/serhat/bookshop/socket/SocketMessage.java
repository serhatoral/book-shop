package dev.serhat.bookshop.socket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocketMessage {

    private String from;
    private String message;
    private String room;
    private String time;

    public SocketMessage(String from, String message) {
        this.from = from;
        this.message = message;

        this.time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }
}

