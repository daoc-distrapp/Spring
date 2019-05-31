package ute.apdist.udp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UdpReceiveApplication implements CommandLineRunner {
	 
	public static void main(String[] args) {
		SpringApplication.run(UdpReceiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Recibiendo mensajes UDP: ENTER para salir");
		System.in.read();
	}
	
}
