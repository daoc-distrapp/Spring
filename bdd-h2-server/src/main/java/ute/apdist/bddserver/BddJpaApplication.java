package ute.apdist.bddserver;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BddJpaApplication implements CommandLineRunner {

	@Autowired
	EstudianteRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BddJpaApplication.class, args);
	}

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2DatabaseServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9091");
    }	
	
	@Override
	public void run(String... args) throws Exception {
		if(repository.count() == 0) {
			repository.save(new Estudiante("Uno", "111"));
			repository.save(new Estudiante("Dos", "222"));
			repository.findAll().forEach(e -> System.out.println(e));
		}
		System.out.println("---LISTO---");
	}
}
