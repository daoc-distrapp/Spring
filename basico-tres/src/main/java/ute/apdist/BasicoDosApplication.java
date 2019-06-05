package ute.apdist;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicoDosApplication implements ApplicationRunner {

	@Autowired
	Date date;
	
	@Autowired
	List<String> list;
	
	@Autowired
	MiObjeto obj;
	
	public static void main(String[] args) {
		SpringApplication.run(BasicoDosApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("RUN: " + date);
		System.out.println("RUN: " + list);
		System.out.println("RUN: " + obj);
	}

	
}
