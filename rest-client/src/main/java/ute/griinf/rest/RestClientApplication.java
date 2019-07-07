package ute.griinf.rest;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {		
		RestTemplate client = new RestTemplate();
		ResponseEntity<?> response;
		
		UnDato dato = client.getForObject("http://localhost:8080/dato/1", UnDato.class);
		System.out.println(dato);
		
		UnDato[] datoS = client.getForObject("http://localhost:8080/datos", UnDato[].class);
		System.out.println(Arrays.toString(datoS));		

		try {
			response = client.postForEntity("http://localhost:8080/dato", new UnDato(5, "cinco", 0.5), HttpEntity.class);
			System.out.println(response);			
		} catch(RestClientResponseException e) {
			System.err.println(e.getResponseBodyAsString());
		}

		datoS = client.getForObject("http://localhost:8080/datos", UnDato[].class);
		System.out.println(Arrays.toString(datoS));	

	}

}
