package ute.apdist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
@EnableJms
public class JmsAmqSubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsAmqSubscriberApplication.class, args);
	}
	
	@JmsListener(destination = "MyQueue")
	public void receiveMessage(String msg) {
		System.out.println("Recibido: " + msg);
	}
	
}
