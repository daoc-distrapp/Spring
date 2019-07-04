package ute.griinf.rest;

public class UnDato {
	public int numero;
	public String nombre;
	public double valor;
	
	public UnDato() {}
	
	public UnDato(int numero, String nombre, double valor) {
		this.numero = numero;
		this.nombre = nombre;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return String.format("UnDato [numero: %d; nombre: %s; valor: %f]", this.numero, this.nombre, this.valor);
	}
}
