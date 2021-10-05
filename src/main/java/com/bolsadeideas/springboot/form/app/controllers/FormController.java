package com.bolsadeideas.springboot.form.app.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.editors.NombreMayusculaEditor;
import com.bolsadeideas.springboot.form.app.editors.PaisPropertyEditor;
import com.bolsadeideas.springboot.form.app.models.domain.Pais;
import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.services.PaisService;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidador validador;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private PaisPropertyEditor paisEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "birthdate", new CustomDateEditor(dateFormat, false));

		binder.registerCustomEditor(String.class, "name", new NombreMayusculaEditor());
		
		binder.registerCustomEditor(Pais.class, "country", paisEditor);
	}

	@ModelAttribute("listCountries")
	public List<Pais> listCountries() {

		return paisService.listar();

	}
	
	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString(){
		
		List<String> roles= new ArrayList<String>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}
	
	@ModelAttribute("listaRolesMap")
	public Map<String, String> listaRolesMap() {

		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERATOR", "Moderador");	

		return roles;

	}

	@ModelAttribute("countries")
	public List<String> countries() {

		return Arrays.asList("España", "Mexico", "Chile", "Argentina", "Perú", "Colombia", "Venezuela");
	}

	@ModelAttribute("countriesMap")
	public Map<String, String> countriesMap() {

		Map<String, String> countries = new HashMap<String, String>();
		countries.put("ES", "España");
		countries.put("MX", "México");
		countries.put("CL", "Chile");
		countries.put("AR", "Argentina");
		countries.put("PE", "Peru");
		countries.put("CO", "Colombia");
		countries.put("VE", "Venezuela");

		return countries;

	}

	@GetMapping("/form")
	public String form(Model model) {

		Usuario usuario = new Usuario();
		usuario.setName("John");
		usuario.setLastname("Doe");
		usuario.setIdentifier("123.456.789-K");
		model.addAttribute("titulo", "Formulario  usuario");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {

		// validador.validate(usuario, result);

		model.addAttribute("titulo", "Resultado form");

		if (result.hasErrors()) {

			return "form";
		}

		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}

}
