package ute.apdist;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class JmsAmqPublisherApplication implements ApplicationRunner {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(JmsAmqPublisherApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Scanner kb = new Scanner(System.in);
		while(kb.hasNextLine()) {
			String msg = kb.nextLine();
			jmsTemplate.convertAndSend("MyQueue", msg);
		}
		kb.close();
	}
	
}
