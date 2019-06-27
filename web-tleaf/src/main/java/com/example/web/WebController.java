package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@GetMapping("/saludo")
	public String hola() {
		return "saludo";
	}

	@GetMapping("/saludoN")
	public String holaNombre(Model model, @RequestParam(name = "n") String nombre) {
		model.addAttribute("name", nombre);
		return "saludoN";
	}
	
	@PostMapping("/saludoC")
	public String holaCargo(Model model, @RequestParam(name = "c") String cargo) {
		String[] roles = new String[] {"perro", "gato", "chancho"};
		model.addAttribute("cargo", cargo);
		model.addAttribute("roles", roles);
		return "saludoC";
	}	
	
}
