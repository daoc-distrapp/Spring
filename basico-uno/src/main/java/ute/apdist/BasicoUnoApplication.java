package ute.apdist;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-using-springbootapplication-annotation.html
// https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html

@SpringBootApplication
public class BasicoUnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicoUnoApplication.class, args);
	}

	/*
	@Bean
	public Date initDate() {
		Date d = new Date();
		System.out.println(d);
		return d;
	}
	
	@Bean
	public List<String> initList() {
		List<String> l = new LinkedList<>();
		l.add("Diego");
		l.add("Ana");
		System.out.println(l);
		return l;
	}	
	*/
	
}
