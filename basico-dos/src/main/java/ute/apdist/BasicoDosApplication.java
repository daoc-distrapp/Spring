package ute.apdist;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Component.html

@SpringBootApplication
public class BasicoDosApplication {

	/*
	@Autowired
	Date date;
	
	@Autowired
	List<String> list;
	
	@Autowired
	MiObjeto obj;
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(BasicoDosApplication.class, args);
	}
	
}
