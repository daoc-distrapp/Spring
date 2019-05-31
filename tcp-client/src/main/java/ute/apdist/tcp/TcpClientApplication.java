package ute.apdist.tcp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcpClientApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(TcpClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inicia envío de mensajes TCP Client: escriba en el teclado !!!");
	}
	
}
