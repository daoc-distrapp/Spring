package ute.apdist.bddjpa;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private int anio;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Estudiante> estudiantes;
		
	public Curso() {}
	
	public Curso(String nombre, int anio) {
		this.nombre = nombre;
		this.anio = anio;
		this.estudiantes = new LinkedList<Estudiante>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		String curso = String.format("Curso [id: %d, nombre: %s, año: %d]\n\t", getId(), getNombre(), getAnio());
		for(Estudiante e : getEstudiantes()) {
			curso += "Est: " + e.getNombre() + " / ";
		}
		return curso + "\n";
	}
	
}
