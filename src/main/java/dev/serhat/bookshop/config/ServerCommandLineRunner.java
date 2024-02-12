package dev.serhat.bookshop.config;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class ServerCommandLineRunner implements CommandLineRunner {
    private final SocketIOServer server;

    public ServerCommandLineRunner(SocketIOServer server) {
        this.server = server;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("socket başlıyorrrrrr");
        server.start();
    }
}
