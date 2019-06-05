package ute.apdist;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/ApplicationRunner.html
// https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/CommandLineRunner.html

@SpringBootApplication
public class BasicoTresApplication implements ApplicationRunner {

	@Autowired
	Date date;
	
	@Autowired
	List<String> list;
	
	@Autowired
	MiObjeto obj;
	
	public static void main(String[] args) {
		SpringApplication.run(BasicoTresApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("RUN: " + date);
		System.out.println("RUN: " + list);
		System.out.println("RUN: " + obj);
	}

	
}
