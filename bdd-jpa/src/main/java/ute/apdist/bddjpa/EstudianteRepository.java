package ute.apdist.bddjpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
	List<Estudiante> findByNombreContaining(String nombre);
	List<Estudiante> findByCedulaContaining(String nombre);
}
