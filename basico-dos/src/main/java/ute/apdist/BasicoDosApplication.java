package ute.apdist;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
