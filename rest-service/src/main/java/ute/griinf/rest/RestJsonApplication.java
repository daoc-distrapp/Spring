package ute.griinf.rest;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestJsonApplication {

	@Bean
	public List<UnDato> datos() {
		List<UnDato> lista = new LinkedList<>();
		lista.add(new UnDato(1, "UNO", 0.1));
		lista.add(new UnDato(2, "DOS", 0.2));
		lista.add(new UnDato(3, "TRES", 0.3));
		lista.add(new UnDato(4, "CUATRO", 0.4));
		return lista;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RestJsonApplication.class, args);
	}

}
