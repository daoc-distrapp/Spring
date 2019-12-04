package ute.apdist.bddclient;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BddJpaApplication implements CommandLineRunner {
	private final Random rnd = new Random();

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(BddJpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("INIT");

		String insertSql = String.format("insert into estudiante values(%d,'client','1234')", rnd.nextLong());
		jdbcTemplate.execute(insertSql);

        List<Estudiante> estudiantes = getEstudiantes("select * from estudiante");
		System.out.println(estudiantes);

		System.out.println("END");
	}
	
	private List<Estudiante> getEstudiantes(String sql) {
		return jdbcTemplate.query(
					sql,
					new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
	}

}
