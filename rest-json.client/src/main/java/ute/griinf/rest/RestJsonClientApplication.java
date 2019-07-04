package ute.griinf.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestJsonClientApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestJsonClientApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		RestTemplate client = new RestTemplate();
		String str = client.getForObject("http://localhost:8080/hola", String.class);
		System.out.println(str);
		
		String datoStr = client.getForObject("http://localhost:8080/holaJson", String.class);
		System.out.println(datoStr);
		
		UnDato dato = client.getForObject("http://localhost:8080/holaJson", UnDato.class);
		System.out.println(dato);
		
		UnDato[] datoS = client.getForObject("http://localhost:8080/holaJsonS", UnDato[].class);
		System.out.println(Arrays.toString(datoS));		
		
		List<UnDato> datoSS = client.getForObject("http://localhost:8080/holaJsonSS", List.class);
		System.out.println(datoSS);				
		
		List<UnDato> datoSSS = client.exchange(
			"http://localhost:8080/holaJsonSS"
			,HttpMethod.GET
			,null
			,new ParameterizedTypeReference<List<UnDato>>(){}).getBody();
		System.out.println(datoSSS);
	}

}
