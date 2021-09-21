package com.bolsadeideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario  usuario");
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(Model model, 
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String email) {
		
		Usuario usuario= new Usuario();
		
		model.addAttribute("titulo", "Resultado form");
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("email", email);
		
		return "resultado";
	}
	
	

}
