package ute.griinf.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
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

		try {
			response = client.postForEntity("http://localhost:8080/create", new UnDato(5, "cinco", 0.5), HttpEntity.class);
			System.out.println(response);	
			response = client.postForEntity("http://localhost:8080/create", new UnDato(7, "siete", 0.7), HttpEntity.class);
			System.out.println(response);				
		} catch(RestClientResponseException e) {
			System.err.println(e.getResponseBodyAsString());
		}

		UnDato[] datoS = client.getForObject("http://localhost:8080/datos", UnDato[].class);
		System.out.println(Arrays.toString(datoS));			
		
		try {
			client.put(new URI("http://localhost:8080/update"), new UnDato(5, "CINCO", 0.555));		
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}		
		
		UnDato dato = client.getForObject("http://localhost:8080/dato/7", UnDato.class);
		
		HttpEntity<UnDato> entity = new HttpEntity<>(dato);
		response = client.exchange(
			"http://localhost:8080/delete"
			,HttpMethod.DELETE
			,entity
			,String.class);
		System.out.println(response);
		
		datoS = client.getForObject("http://localhost:8080/datos", UnDato[].class);
		System.out.println(Arrays.toString(datoS));	

	}

}
