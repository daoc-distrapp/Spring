package ute.griinf.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControll {

	@Autowired
	UnDatoRepository repository;
	
	@GetMapping("/dato/{id}")
	public UnDato getDato(@PathVariable("id") int id) {
		return repository.findById(id).orElse(null);
	}
	
	@GetMapping("/datos")
	public List<UnDato> getDatos() {
		List<UnDato> lista = new ArrayList<>();
		repository.findAll().forEach(lista::add);
		return lista;
	}	
	
	@PostMapping("/create")
	public ResponseEntity<?> postDato(@RequestBody UnDato dato) {
		repository.save(dato);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/update")
	public ResponseEntity<?> putDato(@RequestBody UnDato dato) {
		repository.save(dato);
		return ResponseEntity.ok().build();
	}	
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteDato(@RequestBody UnDato dato) {
		repository.delete(dato);
		return ResponseEntity.ok().build();
	}
	
}
