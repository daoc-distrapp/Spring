package ute.apdist.bddjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Curso {
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private int anio;
		
	public Curso() {}
	
	public Curso(String nombre, int anio) {
		this.nombre = nombre;
		this.anio = anio;
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
	
	@Override
	public String toString() {
		return String.format("Curso [id: %d, nombre: %s, año: %d]", getId(), getNombre(), getAnio());
	}
	
}
