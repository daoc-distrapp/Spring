package ute.griinf.rest;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControll {

	@Autowired
	List<UnDato> datos;
	
	@GetMapping("/dato/{id}")
	public UnDato getDato(@PathVariable("id") int id) {
		for(UnDato dato : datos) {
			if(dato.numero == id) {
				return dato;
			}
		}
		return null;
	}
	
	@GetMapping("/datos")
	public List<UnDato> getDatos() {
		return datos;
	}	
	
	@PostMapping("/dato")
	public void postJson(UnDato dato) {
		datos.add(dato);
	}

	//Ejercicio
	//PUT y DELETE
	
}
