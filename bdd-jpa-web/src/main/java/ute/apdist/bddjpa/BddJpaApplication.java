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
		repository.save(new Estudiante("Uno", "111"));
		repository.save(new Estudiante("Dos", "222"));
		repository.findAll().forEach(e -> System.out.println(e));
		System.out.println("---");
		repository.findByNombreContaining("n").forEach(e -> System.out.println(e));
		System.out.println("---");
		repository.findByNombreContaining("D").forEach(e -> System.out.println(e));
}
}
