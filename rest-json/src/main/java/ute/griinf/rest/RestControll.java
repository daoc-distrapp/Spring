package ute.griinf.rest;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControll {

	@RequestMapping("/hola")
	public String getHola() {
		return "Hola REST !!!";
	}
	
	@RequestMapping("/holaJson")
	public UnDato getJson() {
		return new UnDato(1, "Ana", 10.53);
	}	

	@RequestMapping("/holaJsonS")
	public UnDato[] getJsonS() {
		return new UnDato[]{new UnDato(1, "Ana", 10.53),  new UnDato(2, "Pedro", 5.432)};
	}		
	
	@RequestMapping("/holaJsonSS")
	public List<UnDato> getJsonSS() {
		List<UnDato> lista = new LinkedList<>();
		lista.add(new UnDato(1, "Ana", 10.53));
		lista.add(new UnDato(2, "Pedro", 5.432));
		return lista;
	}
	
}
