package ute.apdist.udp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UdpSendApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(UdpSendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inicia envío de mensajes UDP Multicast: escriba en el teclado !!!");
	}
	
}
