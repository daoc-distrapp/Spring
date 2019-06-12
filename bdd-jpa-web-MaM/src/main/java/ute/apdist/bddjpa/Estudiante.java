package ute.apdist.bddjpa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Estudiante {
	
	Estudiante() {}
	
	public Estudiante(String nombre, String cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.cursos = new LinkedList<Curso>();
	}

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String cedula;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Curso> cursos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	@Override
	public String toString() {
		String estudiante = String.format("Estudiante [%d, %s, %s]\n\t", getId(), getCedula(), getNombre());
		for(Curso c : getCursos()) {
			estudiante += "Curso: " + c.getNombre() + " / ";
		}
		return estudiante + "\n";
	}
}
