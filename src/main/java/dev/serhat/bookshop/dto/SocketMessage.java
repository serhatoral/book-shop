package dev.serhat.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SocketMessage {

    private MessageType type;
    private String message;
    private String room;

    public SocketMessage() {
    }

    public SocketMessage(MessageType type, String message) {
        this.type = type;
        this.message = message;
    }
}

