package ute.apdist.bddjpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
	List<Estudiante> findByNombreContaining(String nombre);
}
