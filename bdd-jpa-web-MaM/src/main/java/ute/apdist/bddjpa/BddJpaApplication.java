package ute.apdist.bddjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BddJpaApplication implements CommandLineRunner {

	@Autowired
	EstudianteRepository repEst;

	@Autowired
	CursoRepository repCur;

	public static void main(String[] args) {
		SpringApplication.run(BddJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estudiante diez = new Estudiante("Diez", "1010");
		Estudiante once = new Estudiante("Once", "1111");

		repEst.save(diez);
		repEst.save(once);

		Curso a = new Curso("AAA", 2010);
		Curso b = new Curso("BBB", 2010);
		Curso c = new Curso("CCC", 2010);
		Curso d = new Curso("DDD", 2010);

		repCur.save(a);
		repCur.save(b);
		repCur.save(c);
		repCur.save(d);

		diez.getCursos().add(a);
		diez.getCursos().add(b);
		once.getCursos().add(c);
		once.getCursos().add(d);

		repEst.save(diez);
		repEst.save(once);

		a.getEstudiantes().add(diez);
		b.getEstudiantes().add(diez);
		c.getEstudiantes().add(once);
		d.getEstudiantes().add(once);

		repCur.save(a);
		repCur.save(b);
		repCur.save(c);
		repCur.save(d);

		System.out.println(repEst.findAll());

		System.out.println(repCur.findAll());

	}
}
