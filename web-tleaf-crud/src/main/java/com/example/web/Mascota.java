package com.example.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mascota {

	public Mascota() {}
	
	public Mascota(String especie, String nombre) {
		this.especie = especie;
		this.nombre = nombre;
	}
	
	@Id
	@GeneratedValue
	private Long id;
	private String especie;
	private String nombre;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return String.format("Mascota [id: %d / especie: %s / nombre: %s] ", getId(), getEspecie(), getNombre());
	}
	
}
