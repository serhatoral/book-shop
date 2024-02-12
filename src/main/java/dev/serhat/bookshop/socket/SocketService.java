package dev.serhat.bookshop.socket;

import com.corundumstudio.socketio.SocketIOClient;
import dev.serhat.bookshop.dto.SocketMessage;
import org.springframework.stereotype.Service;

@Service
public class SocketService {

    public void sendMessage(SocketMessage data, String eventName, SocketIOClient senderClient) {
        for (SocketIOClient client : senderClient.getNamespace().getRoomOperations(data.getRoom()).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent(eventName, new SocketMessage(data.getFrom(), data.getMessage()));
            }
        }
    }
}
