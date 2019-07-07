package ute.griinf.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<?> postJson(@RequestBody UnDato dato) {
		datos.add(dato);
		return ResponseEntity.ok().build();
	}

	//Ejercicio
	//PUT y DELETE
	
}
