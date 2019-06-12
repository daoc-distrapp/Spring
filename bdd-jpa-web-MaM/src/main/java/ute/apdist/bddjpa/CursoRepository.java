package ute.apdist.bddjpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
public interface CursoRepository extends CrudRepository<Curso, Long> {
	List<Curso> findByNombreContaining(String nombre);
}
