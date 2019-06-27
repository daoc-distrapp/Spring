package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@Autowired
	MascotaRepository repository;
	
	//CREATE
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("mascota", new Mascota());
		return "create";
	}

	//UPDATE
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable("id") Long id) {
		model.addAttribute("mascota", repository.findById(id));
		return "update";
	}	
	
	//CREATE & UPDATE
	@PostMapping("/doCreateUpdate")
	public String doCreateUpdate(Model model, Mascota mascota) {
		repository.save(mascota);
		return retrieve(model);
	}	
	
	// RETRIEVE
	@GetMapping("/retrieve")
	public String retrieve(Model model) {
		model.addAttribute("mascotas", repository.findAll());
		return "retrieve";
	}
	
	//DELETE
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) {
		model.addAttribute("mascota", repository.findById(id));
		return "delete";
	}

	@PostMapping("/doDelete")
	public String doDelete(Model model, Mascota mascota) {
		repository.delete(mascota);
		return retrieve(model);
	}			
	
}
