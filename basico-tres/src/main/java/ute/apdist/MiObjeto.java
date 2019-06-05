package ute.apdist;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class MiObjeto {
	private int dato;
	
	public MiObjeto() {
		dato = new Random().nextInt();
		System.out.println("Inicializado mi objeto");
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}
	
	@Override
	public String toString() {
		return String.format("Mi Objeto tiene: %d", getDato());
	}
	
}
