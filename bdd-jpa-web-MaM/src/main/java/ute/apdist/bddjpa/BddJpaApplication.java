package ute.apdist.bddjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BddJpaApplication implements CommandLineRunner {

	@Autowired
	EstudianteRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BddJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estudiante uno = new Estudiante("Uno", "111");
		uno.getCursos().add(new Curso("Mate", 2015));
		uno.getCursos().add(new Curso("Mate", 2018));
		uno.getCursos().add(new Curso("Física", 2019));
		repository.save(uno);
		
		System.out.println(repository.findAll());
		
	}
}
