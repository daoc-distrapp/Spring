package ute.apdist;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicoDosConfig {

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
	
}
