package dev.serhat.bookshop;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableRabbit
public class BookshopApplication implements CommandLineRunner {

	private final SocketIOServer server;

	public BookshopApplication(SocketIOServer server) {
		this.server = server;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookshopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("socket başlıyorrrrrr");
		server.start();
	}

}
