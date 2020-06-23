package ute.griinf.rest;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UnDato {
	@Id
	private int numero;
	private String nombre;
	private double valor;
	
	public UnDato() {}
	public UnDato(int numero, String nombre, double valor) {
		this.numero = numero;
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return String.format("UnDato [numero: %d; nombre: %s; valor: %f]", this.numero, this.nombre, this.valor);
	}
}
