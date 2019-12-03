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

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(BddJpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("INIT");
		
		Long id = new Random().nextLong();
		String insertSql = String.format("insert into estudiante values(%d,'client','1234')", id);
		jdbcTemplate.execute(insertSql);
		
		String selectSql = "select * from estudiante";
        List<Estudiante> estudiantes = 
        	jdbcTemplate.query(
        		selectSql,
                new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
		System.out.println(estudiantes);

		System.out.println("END");
	}
}
