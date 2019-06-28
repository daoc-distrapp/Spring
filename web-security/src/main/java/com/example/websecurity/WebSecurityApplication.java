package com.example.websecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSecurityApplication {

	/**
	 * Si se incluye spring-boot-starter-security en el pom, la aplicación se asegura automáticamente
	 * Al intentar ingresar el sistema redirige a: /login
	 * El usuario por defecto es: user
	 * El password por defecto se genera cada vez que se arranca la aplicación y se ve en la consola. Ej:
	 *   Using generated security password: dea238a0-559e-4e98-92ac-b7ece3c73df7
	 * O lo puede ingresar en application.properties:
	 *   spring.security.user.name: miusr
	 *	 spring.security.user.password: mipwd
	 * Si se ingresan las credenciales correctamente, se redirecciona a la página inicial: /index.html
	 * Si se ingresan las credenciales erróneas, se redirecciona a: /login?error
	 * Para terminar la sesión hay que ir al path: /logout
	 * @param args
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(WebSecurityApplication.class, args);
	}

}
